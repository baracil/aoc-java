package fpc.aoc.year2022.day16;

import fpc.aoc.api.Solver;

public class Day16Part2Solver extends Day16Solver {

  public static Solver provider() {
    return new Day16Part2Solver();
  }

  @Override
  public Long doSolve(Valves input) {
    final var solver = new ValveSolver(input);
    return input.generateBalancedPartitions()
        .parallel()
        .mapToLong(partition -> {
          final var humanTotal = solver.doSolve(partition.first(), 26);
          final var elephantTotal = solver.doSolve(partition.second(), 26);
          return humanTotal + elephantTotal;
        }).max()
        .orElseThrow();
  }
}
