package fpc.aoc.year2015.day17;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

public abstract class Day17Solver extends SmartSolver<int[]> {

  @Override
  protected Converter<int[]> getConverter() {
    return Converter.TO_ARRAY_OF_INT;
  }


}
