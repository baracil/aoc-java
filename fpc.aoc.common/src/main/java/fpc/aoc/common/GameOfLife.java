package fpc.aoc.common;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GameOfLife<T extends NeighbourProvider<T>> {


  private Set<T> aliveCells;
  private final GameOfLifeRule<? super T> gameOfLifeRule;
  private final UnaryOperator<Set<T>> finalizer;
  private final Map<T, Integer> neighbourCount = new HashMap<>();

  public void performCycles(int numberOfCycles) {
    for (int i = 0; i < numberOfCycles; i++) {
      performOneCycle();
    }
  }

  private void performOneCycle() {
    this.clearNeighbourCount();
    aliveCells.forEach(this::increaseNeighbourCount);
    this.updateActiveCubes();
  }

  private void clearNeighbourCount() {
    this.neighbourCount.clear();
  }

  private void increaseNeighbourCount(T cell) {
    cell.neighbours().forEach(this::increaseNeighbourCountAt);
  }

  private void increaseNeighbourCountAt(T position) {
    neighbourCount.merge(position, 1, Integer::sum);
  }

  private void updateActiveCubes() {
    final Predicate<Map.Entry<T, Integer>> isAliveCell = e -> {
      final var position = e.getKey();
      final int nbNeighbour = e.getValue();
      final var currentState = aliveCells.contains(position) ? CellState.ALIVE : CellState.DEAD;
      final var newState = gameOfLifeRule.computeNewState(currentState, nbNeighbour, position);
      return newState == CellState.ALIVE;
    };

    final Set<T> newActiveCells = neighbourCount.entrySet()
        .stream()
        .filter(isAliveCell)
        .map(Map.Entry::getKey)
        .collect(Collectors.toSet());

    aliveCells.clear();
    aliveCells = finalizer.apply(newActiveCells);
  }

  public int numberOfActiveCells() {
    return aliveCells.size();
  }


  public static <T extends NeighbourProvider<T>> GameOfLife<T> initialize(
      ArrayOfChar arrayOfChar,
      BiFunction<Integer, Integer, ? extends T> pointFactory) {
    return initialize(arrayOfChar, pointFactory, GameOfLifeRule.DEFAULT_RULE);
  }

  public static <T extends NeighbourProvider<T>> GameOfLife<T> initialize(
      ArrayOfChar arrayOfChar,
      BiFunction<Integer, Integer, ? extends T> pointFactory,
      GameOfLifeRule<? super T> gameOfLifeRule) {
    final Set<T> listOfPoints = new HashSet<>();
    for (int y = 0; y < arrayOfChar.height(); y++) {
      for (int x = 0; x < arrayOfChar.width(); x++) {
        if (arrayOfChar.get(x, y) == '#') {
          listOfPoints.add(pointFactory.apply(x, y));
        }
      }
    }
    return new GameOfLife<>(listOfPoints, gameOfLifeRule, s -> s);
  }

  public static <T extends NeighbourProvider<T>> GameOfLife<T> initialize(Set<T> initialState) {
    return initialize(initialState, GameOfLifeRule.DEFAULT_RULE, s -> s);
  }

  public static <T extends NeighbourProvider<T>> GameOfLife<T> initialize(Set<T> initialState, GameOfLifeRule<? super T> gameOfLifeRule) {
    return initialize(initialState, gameOfLifeRule, s -> s);
  }

  public static <T extends NeighbourProvider<T>> GameOfLife<T> initialize(Set<T> initialState, GameOfLifeRule<? super T> gameOfLifeRule, UnaryOperator<Set<T>> finalizer) {
    return new GameOfLife<>(new HashSet<>(initialState), gameOfLifeRule, finalizer);
  }

}
