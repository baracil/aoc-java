package fpc.aoc.year2021.day6;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day6.struct.School;
import lombok.NonNull;

public class Day6Part1Solver extends Day6Solver {

  public static @NonNull Solver provider() {
    return new Day6Part1Solver();
  }

  @Override
  public @NonNull String doSolve(@NonNull School input) {
    return input.compute_population(GEN_80).toString();
  }
}
