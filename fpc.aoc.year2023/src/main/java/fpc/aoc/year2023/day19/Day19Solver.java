package fpc.aoc.year2023.day19;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2023.day19.model.Input;

public abstract class Day19Solver extends SmartSolver<Input> {

  @Override
  protected Converter<Input> getConverter() {
    return s -> s.stream().collect(Input.COLLECTOR);
  }
}
