package fpc.aoc.year2020.day3;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Displacement;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day3.structures.TreeCounter;
import lombok.NonNull;

public class Day3Part1Solver extends SmartSolver<TreeCounter> {

  public static @NonNull Solver provider() {
    return new Day3Part1Solver();
  }

  @Override
  protected @NonNull Converter<TreeCounter> getConverter() {
    return Converter.TO_ARRAY_OF_CHAR.andThen(TreeCounter::new);
  }

  @Override
  public @NonNull Long doSolve(@NonNull TreeCounter input) {
    final var displacement = Displacement.of(3, 1);
    return input.count(displacement);
  }
}
