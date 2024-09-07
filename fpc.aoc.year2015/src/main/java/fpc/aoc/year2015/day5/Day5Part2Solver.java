package fpc.aoc.year2015.day5;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day5Part2Solver extends Day5Solver {

  public static @NonNull Solver provider() {
    return new Day5Part2Solver();
  }

  @Override
  public @NonNull Long doSolve(@NonNull Stream<String> input) {
    return input.filter(new NicePredicate2()).count();
  }
}
