package fpc.aoc.year2023.day10;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

public abstract class Day10Solver extends SmartSolver<Map> {

  @Override
  protected Converter<Map> getConverter() {
    return s -> s.stream().collect(Map.COLLECTOR);
  }
}
