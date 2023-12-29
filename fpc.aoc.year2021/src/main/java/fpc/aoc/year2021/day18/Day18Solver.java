package fpc.aoc.year2021.day18;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2021.day18.struct.Number;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day18Solver extends SmartSolver<Stream<Number>> {

  @Override
  protected @NonNull Converter<Stream<Number>> getConverter() {
    return s -> s.stream().map(Number::parse);
  }
}
