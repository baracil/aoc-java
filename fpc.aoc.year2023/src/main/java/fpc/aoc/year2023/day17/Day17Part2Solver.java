package fpc.aoc.year2023.day17;

import fpc.aoc.api.Solver;
import fpc.aoc.common.ArrayOfChar;

public class Day17Part2Solver extends Day17Solver {

  public static Solver provider() {
    return new Day17Part2Solver();
  }

  @Override
  protected Helper createHelper(ArrayOfChar input) {
    return Helper.forPart2(input);
  }
}
