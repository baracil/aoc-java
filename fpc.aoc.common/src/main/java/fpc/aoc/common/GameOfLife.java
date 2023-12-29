package fpc.aoc.common;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class GameOfLife<T extends NeighbourProvider<T>> {

  public static <T extends NeighbourProvider<T>> @NonNull GameOfLife<T> initialize(@NonNull ArrayOfChar arrayOfChar, @NonNull BiFunction<Integer, Integer, ? extends T> pointFactory) {
    final Set<T> listOfPoints = new HashSet<>();
    for (int y = 0; y < arrayOfChar.height(); y++) {
      for (int x = 0; x < arrayOfChar.width(); x++) {
        if (arrayOfChar.get(x, y) == '#') {
          listOfPoints.add(pointFactory.apply(x, y));
        }
      }
    }
    return new GameOfLife<>(listOfPoints, GameOfLifeRule.DEFAULT_RULE);
  }

  public static <T extends NeighbourProvider<T>> @NonNull GameOfLife<T> initialize(@NonNull Set<T> initialState) {
    return new GameOfLife<>(new HashSet<>(initialState), GameOfLifeRule.DEFAULT_RULE);
  }

  public static <T extends NeighbourProvider<T>> @NonNull GameOfLife<T> initialize(@NonNull Set<T> initialState, @NonNull GameOfLifeRule gameOfLifeRule) {
    return new GameOfLife<>(new HashSet<>(initialState), gameOfLifeRule);
  }

  private @NonNull Set<T> aliveCells;
  private final GameOfLifeRule gameOfLifeRule;
  private final @NonNull Map<T, Integer> neighbourCount = new HashMap<>();

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

  private void increaseNeighbourCount(@NonNull T cell) {
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
      final var newState = gameOfLifeRule.computeNewState(currentState, nbNeighbour);
      return newState == CellState.ALIVE;
    };

    final Set<T> newActiveCells = neighbourCount.entrySet()
        .stream()
        .filter(isAliveCell)
        .map(Map.Entry::getKey)
        .collect(Collectors.toSet());

    aliveCells.clear();
    aliveCells = newActiveCells;
  }

  public int numberOfActiveCells() {
    return aliveCells.size();
  }

}
