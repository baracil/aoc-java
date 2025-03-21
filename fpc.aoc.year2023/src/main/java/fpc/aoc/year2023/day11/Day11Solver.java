package fpc.aoc.year2023.day11;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

public abstract class Day11Solver extends SmartSolver<ArrayOfChar> {

  @Override
  protected Converter<ArrayOfChar> getConverter() {
    return Converter.TO_ARRAY_OF_CHAR;
  }
}
