package fpc.aoc.year2023.day24;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day24Solver extends SmartSolver<Stream<String>> {

  @Override
  protected @NonNull Converter<Stream<String>> getConverter() {
    return Converter.TO_STREAM;
  }
}
