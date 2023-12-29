package fpc.aoc.year2021.day7;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.Arrays;

public class Day7Part1Solver extends Day7Solver {

  public static @NonNull Solver provider() {
    return new Day7Part1Solver();
  }

  @Override
  public @NonNull Integer doSolve(@NonNull int[] input) {
    Arrays.sort(input);
    final var target = input[input.length / 2];

    return Arrays.stream(input).map(i -> computeFuel(i, target)).sum();
  }

  public int computeFuel(int position, int target) {
    return Math.abs(position - target);
  }
}
