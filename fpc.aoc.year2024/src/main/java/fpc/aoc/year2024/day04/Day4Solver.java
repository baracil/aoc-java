package fpc.aoc.year2024.day04;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Day4Solver extends SmartSolver<ArrayOfChar> {


  @Override
  protected Converter<ArrayOfChar> getConverter() {
    return Converter.TO_ARRAY_OF_CHAR;
  }

  @Override
  protected Object doSolve(ArrayOfChar input) {
    return input.positionStream()
        .mapToLong(p -> countFrom(input, p))
        .sum();
  }

  protected abstract long countFrom(ArrayOfChar input, Position position);


}
