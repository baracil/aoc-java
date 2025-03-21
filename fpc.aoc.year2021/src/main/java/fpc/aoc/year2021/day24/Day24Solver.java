package fpc.aoc.year2021.day24;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day24Solver extends SmartSolver<Stream<String>> {

  @Override
  protected Converter<Stream<String>> getConverter() {
    return Converter.TO_STREAM;
  }

}
