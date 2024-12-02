package fpc.aoc.year2020.day25;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

public abstract class Day25Solver extends SmartSolver<Day25Input> {

  @Override
  protected Converter<Day25Input> getConverter() {
    return Day25Input::parse;
  }
}
