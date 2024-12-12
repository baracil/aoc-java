package fpc.aoc.year2024.day12;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Day12Solver extends SmartSolver<Field> {

  @Override
  protected Converter<Field> getConverter() {
    return Converter.TO_ARRAY_OF_CHAR.andThen(Field::new);
  }

}
