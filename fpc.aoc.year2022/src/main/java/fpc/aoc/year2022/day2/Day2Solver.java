package fpc.aoc.year2022.day2;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;
import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class Day2Solver extends SmartSolver<Stream<Turn>> {

  private final Function<String, Turn> converter;

  @Override
  protected @NonNull Converter<Stream<Turn>> getConverter() {
    return s -> s.stream().map(converter);
  }

  @Override
  public @NonNull Integer doSolve(@NonNull Stream<Turn> input) {
    return input.mapToInt(Turn::getScore).sum();
  }

}
