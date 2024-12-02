package fpc.aoc.year2022.day4;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day4Solver extends SmartSolver<Stream<AssignmentPair>> {

  @Override
  protected Converter<Stream<AssignmentPair>> getConverter() {
    return s -> s.stream().map(AssignmentPair::parse);
  }
}
