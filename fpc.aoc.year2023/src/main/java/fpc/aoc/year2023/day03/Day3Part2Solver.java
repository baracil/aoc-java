package fpc.aoc.year2023.day03;

import fpc.aoc.api.Solver;

public class Day3Part2Solver extends Day3Solver {

  public static Solver provider() {
    return new Day3Part2Solver();
  }

  @Override
  public Object doSolve(Schematic input) {
    return input.gearRatio().sum();
  }
}
