package fpc.aoc.year2015.day1;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day1Part1Solver extends Day1Solver {

  public static Solver provider() {
    return new Day1Part1Solver();
  }

  @Override
  public @NonNull Object doSolve(@NonNull String input) {
    return input.chars().map(i -> i == '(' ? 1 : -1).sum();
  }
}
