package fpc.aoc.year2021.day3;

import fpc.aoc.api.Solver;

public class Day3Part1Solver extends Day3Solver {

  public static Solver provider() {
    return new Day3Part1Solver();
  }

  @Override
  public String doSolve(DiagnosticReport input) {
    return PowerConsumption.fromDiagnostic(input).getRateProduct();
  }
}
