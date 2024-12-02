package fpc.aoc.year2023.day13;

import fpc.aoc.api.Solver;

public class Day13Part1Solver extends Day13Solver {

  public static Solver provider() {
    return new Day13Part1Solver();
  }


  @Override
  protected Checker createChecker() {
    return new Part1Checker();
  }
}
