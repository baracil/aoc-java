package fpc.aoc.year2024.day08;

import fpc.aoc.api.Solver;
import fpc.aoc.common.ArrayOfChar;

public class Day8Part2Solver extends Day8Solver {

  public static Solver provider() {
    return new Day8Part2Solver();
  }

  @Override
  protected Object doSolve(ArrayOfChar input) {
    return AntiNodeCounter.countAntiNodesForPart2(input);
  }

}
