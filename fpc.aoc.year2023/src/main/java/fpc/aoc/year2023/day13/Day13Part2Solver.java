package fpc.aoc.year2023.day13;

import fpc.aoc.api.Solver;

public class Day13Part2Solver extends Day13Solver {

  public static Solver provider() {
    return new Day13Part2Solver();
  }

  @Override
  protected Checker createChecker() {
    return new Part2Checker();
  }
}
