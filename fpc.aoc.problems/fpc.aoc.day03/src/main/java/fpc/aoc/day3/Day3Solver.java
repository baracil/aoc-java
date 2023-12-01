package fpc.aoc.day3;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day3Solver extends SmartSolver<Stream<String>, String> {

  @Override
  protected @NonNull Converter<Stream<String>> getConverter() {
    return Converter.IDENTITY;
  }
}
