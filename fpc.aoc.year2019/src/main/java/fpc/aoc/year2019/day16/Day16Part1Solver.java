package fpc.aoc.year2019.day16;

import fpc.aoc.api.Solver;

public class Day16Part1Solver extends Day16Solver {

  public static Solver provider() {
    return new Day16Part1Solver();
  }

  @Override
  protected Object doSolve(Signal signal) {
    return signal.applyFFT(100).getFirstEightDigits();
  }
}
