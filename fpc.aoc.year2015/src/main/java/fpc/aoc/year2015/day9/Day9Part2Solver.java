package fpc.aoc.year2015.day9;

import fpc.aoc.api.Solver;

public class Day9Part2Solver extends Day9Solver {

  public static Solver provider() {
    return new Day9Part2Solver();
  }

  @Override
  protected Object doSolve(Input input) {
    final var s = new LongestSolver(input);
    for (String city : input.cities()) {
      s.process(city);
    }
    return s.best();
  }
}
