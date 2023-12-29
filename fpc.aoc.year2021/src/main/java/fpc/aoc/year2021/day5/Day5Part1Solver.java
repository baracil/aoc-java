package fpc.aoc.year2021.day5;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day5.struct.Vent;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day5Part1Solver extends Day5Solver {

  public static @NonNull Solver provider() {
    return new Day5Part1Solver();
  }

  @Override
  public @NonNull String doSolve(@NonNull Stream<Vent> input) {
    return doSolve(input, Vent::isVerticalOrHorizontal);
  }
}
