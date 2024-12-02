package fpc.aoc.year2023.day03;

import fpc.aoc.api.Solver;

public class Day3Part1Solver extends Day3Solver {

  public static Solver provider() {
    return new Day3Part1Solver();
  }

  @Override
  public Object doSolve(Schematic input) {
    return (long) input.numberCloseToSymbol().sum();
  }

}
