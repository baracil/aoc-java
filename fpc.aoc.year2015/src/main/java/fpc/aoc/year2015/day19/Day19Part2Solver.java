package fpc.aoc.year2015.day19;

import fpc.aoc.api.Solver;

public class Day19Part2Solver extends Day19Solver {

  public static Solver provider() {
    return new Day19Part2Solver();
  }

  @Override
  public Long doSolve(Input input) {
    return Synthesizer.synthesize(input);
  }
}
