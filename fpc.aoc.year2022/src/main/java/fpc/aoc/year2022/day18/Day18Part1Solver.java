package fpc.aoc.year2022.day18;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.Set;

public class Day18Part1Solver extends Day18Solver {

  public static @NonNull Solver provider() {
    return new Day18Part1Solver();
  }

  @Override
  public @NonNull Integer doSolve(@NonNull Set<Face> input) {
    return input.size();
  }
}
