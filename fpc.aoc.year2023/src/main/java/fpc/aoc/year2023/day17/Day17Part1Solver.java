package fpc.aoc.year2023.day17;

import fpc.aoc.api.Solver;
import fpc.aoc.common.ArrayOfChar;

public class Day17Part1Solver extends Day17Solver {

  public static Solver provider() {
    return new Day17Part1Solver();
  }

  @Override
  protected Helper createHelper(ArrayOfChar input) {
    return Helper.forPart1(input);
  }
}
