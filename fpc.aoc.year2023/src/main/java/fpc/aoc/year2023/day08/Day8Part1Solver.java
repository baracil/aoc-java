package fpc.aoc.year2023.day08;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day8Part1Solver extends Day8Solver {

  public static @NonNull Solver provider() {
    return new Day8Part1Solver();
  }

  @Override
  public @NonNull Object doSolve(@NonNull Input input) {
    return String.valueOf(input.part1());
  }
}
