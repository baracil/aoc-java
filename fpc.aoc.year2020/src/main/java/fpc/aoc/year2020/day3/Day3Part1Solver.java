package fpc.aoc.year2020.day3;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Displacement;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day3.structures.TreeCounter;

public class Day3Part1Solver extends SmartSolver<TreeCounter> {

  public static Solver provider() {
    return new Day3Part1Solver();
  }

  @Override
  protected Converter<TreeCounter> getConverter() {
    return Converter.TO_ARRAY_OF_CHAR.andThen(TreeCounter::new);
  }

  @Override
  public Long doSolve(TreeCounter input) {
    final var displacement = Displacement.of(3, 1);
    return input.count(displacement);
  }
}
