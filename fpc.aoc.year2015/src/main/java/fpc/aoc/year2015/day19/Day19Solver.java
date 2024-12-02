package fpc.aoc.year2015.day19;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

public abstract class Day19Solver extends SmartSolver<Input> {

  @Override
  protected Converter<Input> getConverter() {
    return s -> s.stream().collect(Input.COLLECTOR);
  }
}
