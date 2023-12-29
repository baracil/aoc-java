package fpc.aoc.year2023.day03;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day3Solver extends SmartSolver<Schematic> {

  @Override
  protected @NonNull Converter<Schematic> getConverter() {
    return Converter.IDENTITY.andThen(Schematic::from);
  }
}
