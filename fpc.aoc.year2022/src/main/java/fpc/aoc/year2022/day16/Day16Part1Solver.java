package fpc.aoc.year2022.day16;

import fpc.aoc.api.Solver;

public class Day16Part1Solver extends Day16Solver {

  public static Solver provider() {
    return new Day16Part1Solver();
  }

  @Override
  public Long doSolve(Valves input) {
    return new ValveSolver(input).doSolve(0, 30);
  }
}
