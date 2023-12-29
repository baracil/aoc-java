package fpc.aoc.year2023.day22;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day22Solver extends SmartSolver<Stream<String>> {

  @Override
  protected @NonNull Converter<Stream<String>> getConverter() {
    return Converter.TO_STREAM;
  }
}
