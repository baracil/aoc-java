package fpc.aoc.year2020.day23;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

public abstract class Day23Solver extends SmartSolver<String> {

  @Override
  protected Converter<String> getConverter() {
    return Converter.FIRST_LINE;
  }

}
