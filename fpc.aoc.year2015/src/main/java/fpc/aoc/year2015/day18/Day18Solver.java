package fpc.aoc.year2015.day18;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day18Solver extends SmartSolver<ArrayOfChar> {

  @Override
  protected @NonNull Converter<ArrayOfChar> getConverter() {
    return Converter.TO_ARRAY_OF_CHAR;
  }



}
