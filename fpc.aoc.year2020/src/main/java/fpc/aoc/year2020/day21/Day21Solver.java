package fpc.aoc.year2020.day21;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day21.structures.Guide;

public abstract class Day21Solver extends SmartSolver<Guide> {

  @Override
  protected Converter<Guide> getConverter() {
    return s -> s.stream().collect(Guide.collector());
  }
}
