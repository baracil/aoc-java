package fpc.aoc.year2020.day23;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day23Solver extends SmartSolver<String> {

  @Override
  protected @NonNull Converter<String> getConverter() {
    return Converter.FIRST_LINE;
  }

}
