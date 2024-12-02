package fpc.aoc.year2023.day14;

import fpc.aoc.api.Solver;
import fpc.aoc.year2023.day14.model.Platform;

public class Day14Part1Solver extends Day14Solver {

  public static Solver provider() {
    return new Day14Part1Solver();
  }

  @Override
  public Object doSolve(Platform input) {
    input.tileToNorth();
    return input.computeNorthWeight();
  }
}
