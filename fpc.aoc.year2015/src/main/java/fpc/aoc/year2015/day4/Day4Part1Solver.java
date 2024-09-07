package fpc.aoc.year2015.day4;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day4Part1Solver extends Day4Solver {

  public static @NonNull Solver provider() {
    return new Day4Part1Solver();
  }

  @Override
  public @NonNull Integer doSolve(@NonNull String input) {
    return solve(input,0xF0);
  }
}
