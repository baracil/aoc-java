package fpc.aoc.year2020.day16;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day16Solver extends SmartSolver<Input> {

  @Override
  protected @NonNull Converter<Input> getConverter() {
    return Input::parse;
  }
}
