package fpc.aoc.year2021.day23;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day23Solver extends SmartSolver<Stream<String>> {

  @Override
  protected Converter<Stream<String>> getConverter() {
    return Converter.TO_STREAM;
  }
}
