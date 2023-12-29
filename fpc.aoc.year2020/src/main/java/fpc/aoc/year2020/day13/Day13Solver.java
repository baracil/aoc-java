package fpc.aoc.year2020.day13;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day13Solver extends SmartSolver<Notes> {

  @Override
  protected @NonNull Converter<Notes> getConverter() {
    return Notes::parse;
  }

}
