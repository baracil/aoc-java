package fpc.aoc.year2024.day06;

import fpc.aoc.api.Solver;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;

import java.util.HashSet;

public class Day6Part2Solver extends Day6Solver {

  public static Solver provider() {
    return new Day6Part2Solver();
  }

  @Override
  protected Object doSolve(ArrayOfChar map, Guard guard) {
    final var visited = getVisited(map, guard);
    final var startingPosition = guard.position();

    return visited.stream()
        .map(Guard::position)
        .filter(o -> !o.equals(startingPosition))
        .distinct()
        .filter(o -> isStuck(map, o, guard))
        .count();

  }

  private boolean isStuck(ArrayOfChar map, Position obstacle, Guard guard) {
    final var visited = new HashSet<Guard>();
    Guard current = guard;
    while (current != null) {
      visited.add(current);
      current = current.move(map, obstacle);
      if (current == null) {
        return false;
      }
      if (visited.contains(current)) {
        return true;
      }
    }
    return false;
  }
}
