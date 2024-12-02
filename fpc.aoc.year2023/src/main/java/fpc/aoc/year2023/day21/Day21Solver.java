package fpc.aoc.year2023.day21;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;
import fpc.aoc.common.Tools;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.UnaryOperator;

public abstract class Day21Solver extends SmartSolver<ArrayOfChar> {

  @Override
  protected Converter<ArrayOfChar> getConverter() {
    return Converter.TO_ARRAY_OF_CHAR;
  }

  private static final List<UnaryOperator<Elf>> MOVES = List.of(
      Elf::down, Elf::left, Elf::right, Elf::up
  );

  @Override
  public Object doSolve(ArrayOfChar input) {
    final var start = input.findMatching('S').orElseThrow(() -> new AOCException("Could not find starting point"));
    return doSolve(input, start);
  }

  protected abstract int getNbSteps();

  public Object doSolve(ArrayOfChar input, Position startingPoint) {
    long nbReachable = 0;
    final int nbSteps = this.getNbSteps();
    final int parity = nbSteps % 2;
    final var visited = new HashSet<Position>();
    final Deque<Elf> toVisit = new LinkedList<>();
    toVisit.addLast(new Elf(startingPoint, nbSteps));
    visited.add(startingPoint);
    while (!toVisit.isEmpty()) {
      final var next = toVisit.removeFirst();
      if (next.nbStepsRemaining % 2 == parity) {
        nbReachable++;
      }
      if (next.nbStepsRemaining == 0) {
        continue;
      }

      MOVES.stream()
          .map(move -> move.apply(next))
          .forEach(e -> {
            final var x = Tools.mod(e.position.x(), input.width());
            final var y = Tools.mod(e.position.y(), input.height());
            final var c = input.get(x, y);
            if (c != '#' && visited.add(e.position)) {
              toVisit.addLast(e);
            }
          });
    }

    return nbReachable;
  }

  public record Elf(Position position, int nbStepsRemaining) {
    public Elf up() {
      return new Elf(position.up(), nbStepsRemaining - 1);
    }

    public Elf down() {
      return new Elf(position.down(), nbStepsRemaining - 1);
    }

    public Elf left() {
      return new Elf(position.left(), nbStepsRemaining - 1);
    }

    public Elf right() {
      return new Elf(position.right(), nbStepsRemaining - 1);
    }

  }

}
