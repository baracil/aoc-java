package fpc.aoc.year2021.day11;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

public abstract class Day11Solver extends SmartSolver<Map> {

  @Override
  protected Converter<Map> getConverter() {
    return ArrayMap::parse;
  }
}
