package fpc.aoc.year2023.day05;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2023.day05.data.Input;

public abstract class Day5Solver extends SmartSolver<Input> {

  @Override
  protected Converter<Input> getConverter() {
    return s -> s.stream().collect(Input.COLLECTOR);
  }
}
