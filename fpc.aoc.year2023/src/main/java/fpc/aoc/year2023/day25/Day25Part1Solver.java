package fpc.aoc.year2023.day25;

import fpc.aoc.api.Solver;
import fpc.aoc.common.NotSolvedYet;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day25Part1Solver extends Day25Solver {

  public static @NonNull Solver provider() {
    return new Day25Part1Solver();
  }

  @Override
  public boolean isSkipped() {
    return true;
  }

  @Override
  public @NonNull Object doSolve(@NonNull Stream<String> input) {
    throw new NotSolvedYet();
  }
}
