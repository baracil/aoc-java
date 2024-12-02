package fpc.aoc.year2021.day4;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2021.day4.struct.Day04Input;

public abstract class Day4Solver extends SmartSolver<Day04Input> {

  @Override
  protected Converter<Day04Input> getConverter() {
    return s -> s.stream().collect(Day04Input.COLLECTOR);
  }
}
