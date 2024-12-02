package fpc.aoc.year2015.day9;

import fpc.aoc.api.Solver;

public class Day9Part1Solver extends Day9Solver {

  public static Solver provider() {
    return new Day9Part1Solver();
  }

  @Override
  protected Object doSolve(Input input) {
    final var s = new ShortedSolver(input);
    for (String city : input.cities()) {
      s.process(city);
    }
    return s.best();
  }


}
