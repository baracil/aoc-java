package fpc.aoc.year2020.day3;


import fpc.aoc.api.Solver;
import fpc.aoc.common.Displacement;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day3.structures.TreeCounter;

import java.util.stream.Stream;

public class Day3Part2Solver extends SmartSolver<TreeCounter> {

  public static Solver provider() {
    return new Day3Part2Solver();
  }

  @Override
  protected Converter<TreeCounter> getConverter() {
    return Converter.TO_ARRAY_OF_CHAR.andThen(TreeCounter::new);
  }

  @Override
  public Long doSolve(TreeCounter input) {
    return Stream.of(Displacement.of(1, 1),
            Displacement.of(3, 1),
            Displacement.of(5, 1),
            Displacement.of(7, 1),
            Displacement.of(1, 2))
        .mapToLong(input::count)
        .reduce(1, (l1, l2) -> l1 * l2);
  }
}
