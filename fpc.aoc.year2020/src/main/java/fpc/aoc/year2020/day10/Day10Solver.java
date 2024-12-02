package fpc.aoc.year2020.day10;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

public abstract class Day10Solver extends SmartSolver<int[]> {

  @Override
  protected Converter<int[]> getConverter() {
    return Converter.TO_ARRAY_OF_INT;
  }
}
