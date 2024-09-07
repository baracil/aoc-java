package fpc.aoc.year2015.day8;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day8Part2Solver extends Day8Solver {

  public static @NonNull Solver provider() {
    return new Day8Part2Solver();
  }

  @Override
  protected @NonNull Object doSolve(@NonNull Stream<String> input) {
    return input.mapToLong(s -> StrTools.newEncodeLength(s) - StrTools.codeLength(s)).sum();
  }
}
