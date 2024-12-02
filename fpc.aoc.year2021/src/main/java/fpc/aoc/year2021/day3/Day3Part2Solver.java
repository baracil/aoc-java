package fpc.aoc.year2021.day3;

import fpc.aoc.api.Solver;

public class Day3Part2Solver extends Day3Solver {

  public static Solver provider() {
    return new Day3Part2Solver();
  }

  @Override
  public String doSolve(DiagnosticReport input) {
    return LifeSupport.from(input).getRatingProduct();

  }
}
