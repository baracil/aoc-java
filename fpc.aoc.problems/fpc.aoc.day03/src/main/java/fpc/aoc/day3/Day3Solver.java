package fpc.aoc.day3;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day3Solver extends SmartSolver<Schematic, Long> {

  @Override
  protected @NonNull Converter<Schematic> getConverter() {
    return Converter.ALL_LINES.andThen(Schematic::from);
  }
}
