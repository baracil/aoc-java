package fpc.aoc.year2021.day3;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

public abstract class Day3Solver extends SmartSolver<DiagnosticReport> {

  @Override
  protected Converter<DiagnosticReport> getConverter() {
    return DiagnosticReport::fromLines;
  }

}
