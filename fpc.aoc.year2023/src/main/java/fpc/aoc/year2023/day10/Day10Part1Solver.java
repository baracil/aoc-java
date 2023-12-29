package fpc.aoc.year2023.day10;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day10Part1Solver extends Day10Solver {

  public static @NonNull Solver provider() {
    return new Day10Part1Solver();
  }


  @Override
  public @NonNull Object doSolve(@NonNull Map input) {
    final var cycle = input.cycle();
    return cycle.size() / 2;
  }
}
