package fpc.aoc.year2021.day3;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day3Solver extends SmartSolver<DiagnosticReport> {

  @Override
  protected @NonNull Converter<DiagnosticReport> getConverter() {
    return DiagnosticReport::fromLines;
  }

}
