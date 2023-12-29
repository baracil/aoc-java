package fpc.aoc.year2023.day09;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day9Part1Solver extends Day9Solver {

  public static @NonNull Solver provider() {
    return new Day9Part1Solver();
  }

  @Override
  public @NonNull Object doSolve(@NonNull Stream<long[]> input) {
    return input.mapToLong(Extrapoler::computePart1).sum();
  }
}
