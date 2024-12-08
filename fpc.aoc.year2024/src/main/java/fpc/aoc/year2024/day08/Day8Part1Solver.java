package fpc.aoc.year2024.day08;

import fpc.aoc.api.Solver;
import fpc.aoc.common.ArrayOfChar;

public class Day8Part1Solver extends Day8Solver {

  public static Solver provider() {
    return new Day8Part1Solver();
  }

  @Override
  protected Object doSolve(ArrayOfChar input) {
    return AntiNodeCounter.countAntiNodesForPart1(input);
  }

}
