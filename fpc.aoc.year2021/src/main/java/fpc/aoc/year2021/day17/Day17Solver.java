package fpc.aoc.year2021.day17;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2021.day17.struct.Target;

public abstract class Day17Solver extends SmartSolver<Target> {

  @Override
  protected Converter<Target> getConverter() {
    return Converter.FIRST_LINE.andThen(Target::parse);
  }
}
