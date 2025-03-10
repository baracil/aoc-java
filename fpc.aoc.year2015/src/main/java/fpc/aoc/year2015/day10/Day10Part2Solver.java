package fpc.aoc.year2015.day10;

import fpc.aoc.api.Solver;

public class Day10Part2Solver extends Day10Solver {

  public static Solver provider() {
    return new Day10Part2Solver();
  }

  @Override
  protected int nbIterations() {
    return 50;
  }
}
