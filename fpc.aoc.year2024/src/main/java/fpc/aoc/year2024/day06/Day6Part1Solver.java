package fpc.aoc.year2024.day06;

import fpc.aoc.api.Solver;
import fpc.aoc.common.ArrayOfChar;

public class Day6Part1Solver extends Day6Solver {

  public static Solver provider() {
    return new Day6Part1Solver();
  }

  @Override
  protected Object doSolve(ArrayOfChar map, Guard guard) {
    final var visited = getVisited(map,guard);

    return visited.stream().map(Guard::position).distinct().count();
  }
}
