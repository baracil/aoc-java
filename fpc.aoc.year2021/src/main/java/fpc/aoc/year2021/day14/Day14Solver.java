package fpc.aoc.year2021.day14;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2021.day14.struct.Input;

public abstract class Day14Solver extends SmartSolver<Input> {

  @Override
  protected Converter<Input> getConverter() {
    return s -> s.stream().collect(Input.COLLECTOR);
  }


}
