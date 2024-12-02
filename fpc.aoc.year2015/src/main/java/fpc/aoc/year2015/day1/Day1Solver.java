package fpc.aoc.year2015.day1;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Day1Solver extends SmartSolver<String> {

  @Override
  protected Converter<String> getConverter() {
    return Converter.FIRST_LINE;
  }


}
