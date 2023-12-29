package fpc.aoc.year2023.day17;

import fpc.aoc.api.Solver;
import fpc.aoc.common.ArrayOfChar;
import lombok.NonNull;

public class Day17Part1Solver extends Day17Solver {

  public static @NonNull Solver provider() {
    return new Day17Part1Solver();
  }

  @Override
  protected Helper createHelper(@NonNull ArrayOfChar input) {
    return Helper.forPart1(input);
  }
}
