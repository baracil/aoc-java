package fpc.aoc.day17;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.ArrayOfChar;
import lombok.NonNull;

public class Day17Part1Solver extends Day17Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day17Part1Solver().createProblem();
  }

  @Override
  protected Helper createHelper(@NonNull ArrayOfChar input) {
    return Helper.forPart1(input);
  }
}
