package fpc.aoc.year2023.day08;

import fpc.aoc.api.Solver;

public class Day8Part1Solver extends Day8Solver {

  public static Solver provider() {
    return new Day8Part1Solver();
  }

  @Override
  public Object doSolve(Input input) {
    return String.valueOf(input.part1());
  }
}
