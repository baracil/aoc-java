package fpc.aoc.year2015.day17;

import fpc.aoc.api.Solver;

public class Day17Part1Solver extends Day17Solver {

  public static Solver provider() {
    return new Day17Part1Solver();
  }

  @Override
  protected Object doSolve(int[] input) {
    return SolverPart1.solve(150, input);
  }
}
