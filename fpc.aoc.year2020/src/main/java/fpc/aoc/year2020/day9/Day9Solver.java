package fpc.aoc.year2020.day9;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

public abstract class Day9Solver extends SmartSolver<long[]> {

  @Override
  protected Converter<long[]> getConverter() {
    return Converter.TO_ARRAY_OF_LONG;
  }
}
