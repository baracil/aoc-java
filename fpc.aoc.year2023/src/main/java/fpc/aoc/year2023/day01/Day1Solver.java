package fpc.aoc.year2023.day01;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

import java.util.function.ToIntFunction;
import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class Day1Solver extends SmartSolver<Stream<String>> {

  @Override
  protected Converter<Stream<String>> getConverter() {
    return Converter.TO_STREAM;
  }

  protected abstract ToIntFunction<String> getLineConverter();

  @Override
  public Object doSolve(Stream<String> input) {
    final var sum = input.mapToInt(getLineConverter()).sum();
    return String.valueOf(sum);
  }
}
