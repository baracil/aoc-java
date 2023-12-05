package fpc.aoc.day5;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.day5.data.Input;
import lombok.NonNull;

import java.util.Arrays;

public class Day5Part1Solver extends Day5Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day5Part1Solver().createProblem();
  }

  @Override
  public @NonNull String solve(@NonNull Input input) {
    final var min = Arrays
      .stream(input.seeds1())
      .map(input::map)
      .min()
      .orElse(0);

    return String.valueOf(min);
  }

}
