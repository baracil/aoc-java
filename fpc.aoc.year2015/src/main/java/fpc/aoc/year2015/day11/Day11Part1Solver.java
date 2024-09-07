package fpc.aoc.year2015.day11;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day11Part1Solver extends Day11Solver {

  public static @NonNull Solver provider() {
    return new Day11Part1Solver();
  }

  @Override
  public @NonNull String doSolve(@NonNull String input) {
    final var p = Password.of(input);
    do {
      p.increment();
    } while (!p.isValid());
    return p.toString();
  }
}
