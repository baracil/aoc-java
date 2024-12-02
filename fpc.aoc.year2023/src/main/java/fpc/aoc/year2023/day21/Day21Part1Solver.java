package fpc.aoc.year2023.day21;

import fpc.aoc.api.Solver;

public class Day21Part1Solver extends Day21Solver {

  public static Solver provider() {
    return new Day21Part1Solver();
  }

  @Override
  protected int getNbSteps() {
    return 64;
  }
}
