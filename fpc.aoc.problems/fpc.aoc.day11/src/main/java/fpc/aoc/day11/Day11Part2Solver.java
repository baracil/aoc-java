package fpc.aoc.day11;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.ArrayOfChar;
import lombok.NonNull;

public class Day11Part2Solver extends Day11Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day11Part2Solver().createProblem();
  }

  @Override
  public @NonNull Long solve(@NonNull ArrayOfChar input) {
    return Solver.find(input, 1000000);
  }
}
