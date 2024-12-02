package fpc.aoc.year2022.day24;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

public abstract class Day24Solver extends SmartSolver<Map> {

  @Override
  protected Converter<Map> getConverter() {
    return Converter.toArrayOfChar('#').andThen(Map::new);
  }
}
