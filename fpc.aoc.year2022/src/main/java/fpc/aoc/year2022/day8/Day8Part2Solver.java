package fpc.aoc.year2022.day8;

import fpc.aoc.api.Solver;

public class Day8Part2Solver extends Day8Solver {

  public static Solver provider() {
    return new Day8Part2Solver();
  }

  @Override
  public Long doSolve(Forest forest) {
    return forest.getBestScenicScore();
  }
}
