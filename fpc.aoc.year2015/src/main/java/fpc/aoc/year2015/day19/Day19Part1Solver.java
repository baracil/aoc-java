package fpc.aoc.year2015.day19;

import fpc.aoc.api.Solver;

public class Day19Part1Solver extends Day19Solver {

  public static Solver provider() {
    return new Day19Part1Solver();
  }

  @Override
  public Long doSolve(Input input) {
    return Calibrator.calibrate(input);
  }
}
