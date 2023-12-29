package fpc.aoc.year2021.day3;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day3Part2Solver extends Day3Solver {

  public static @NonNull Solver provider() {
    return new Day3Part2Solver();
  }

  @Override
  public @NonNull String doSolve(@NonNull DiagnosticReport input) {
    return LifeSupport.from(input).getRatingProduct();

  }
}
