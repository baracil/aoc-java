package fpc.aoc.year2022.day8;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day8Solver extends SmartSolver<Forest> {

  @Override
  protected @NonNull Converter<Forest> getConverter() {
    return s -> new Forest(ArrayOfChar.from(s, ' '));
  }
}
