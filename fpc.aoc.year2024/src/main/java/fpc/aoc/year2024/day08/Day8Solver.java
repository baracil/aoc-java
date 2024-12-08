package fpc.aoc.year2024.day08;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Day8Solver extends SmartSolver<ArrayOfChar> {

  public static final char OUT_SIDE = '█';

  @Override
  protected Converter<ArrayOfChar> getConverter() {
    return l -> ArrayOfChar.from(l, OUT_SIDE);
  }

}
