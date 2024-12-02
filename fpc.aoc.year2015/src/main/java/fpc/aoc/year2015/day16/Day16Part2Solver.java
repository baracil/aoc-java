package fpc.aoc.year2015.day16;

import fpc.aoc.api.Solver;

public class Day16Part2Solver extends Day16Solver {

  public static Solver provider() {
    return new Day16Part2Solver();
  }

  @Override
  protected TestFactory createTestFactory() {
    return new TestFactory.Part2();
  }
}
