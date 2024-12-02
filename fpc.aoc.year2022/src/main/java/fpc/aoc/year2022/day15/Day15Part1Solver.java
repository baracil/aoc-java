package fpc.aoc.year2022.day15;

import fpc.aoc.api.Solver;

public class Day15Part1Solver extends Day15Solver {

  public static Solver provider() {
    return new Day15Part1Solver();
  }

  private final int lineNumber;

  public Day15Part1Solver(int lineNumber) {
    this.lineNumber = lineNumber;
  }

  public Day15Part1Solver() {
    lineNumber = 2000000;
  }

  @Override
  public Long doSolve(Report input) {
    return input.computePart1(lineNumber);
  }
}
