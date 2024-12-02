package fpc.aoc.year2015.day17;

import fpc.aoc.api.Solver;

public class Day17Part2Solver extends Day17Solver {

  public static Solver provider() {
    return new Day17Part2Solver();
  }

  @Override
  public Integer doSolve(int[] input) {
    return SolverPart2.solve(150, input);
  }
}
