package fpc.aoc.year2015.day11;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

public abstract class Day11Solver extends SmartSolver<String> {

  @Override
  protected Converter<String> getConverter() {
    return Converter.FIRST_LINE;
  }
}
