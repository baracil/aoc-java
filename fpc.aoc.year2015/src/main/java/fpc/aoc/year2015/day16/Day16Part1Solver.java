package fpc.aoc.year2015.day16;

import fpc.aoc.api.Solver;

public class Day16Part1Solver extends Day16Solver {

  public static Solver provider() {
    return new Day16Part1Solver();
  }


  @Override
  protected TestFactory createTestFactory() {
    return new TestFactory.Part1();
  }
}
