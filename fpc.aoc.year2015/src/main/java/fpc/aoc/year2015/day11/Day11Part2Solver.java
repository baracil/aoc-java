package fpc.aoc.year2015.day11;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day11Part2Solver extends Day11Solver {

  public static @NonNull Solver provider() {
    return new Day11Part2Solver();
  }

  @Override
  protected @NonNull Object doSolve(@NonNull String input) {
    final var p = Password.of(input);
    int nb = 0;
    do {
      p.increment();
      if (p.isValid()) {
        nb++;
      }
    } while (nb != 2);
    return p.toString();
  }
}
