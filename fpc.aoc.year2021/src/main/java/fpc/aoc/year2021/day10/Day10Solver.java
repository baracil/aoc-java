package fpc.aoc.year2021.day10;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day10Solver extends SmartSolver<Stream<String>> {


  @Override
  protected @NonNull Converter<Stream<String>> getConverter() {
    return Converter.TO_STREAM;
  }
}
