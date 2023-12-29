package fpc.aoc.year2021.day1;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;

@RequiredArgsConstructor
public abstract class Day1Solver extends SmartSolver<int[]> {

  private final int step;

  @Override
  protected @NonNull Converter<int[]> getConverter() {
    return Converter.TO_ARRAY_OF_INT;
  }


  @Override
  public @NonNull Long doSolve(int @NonNull [] input) {
    return IntStream.range(0, input.length - step)
        .filter(pos -> input[pos + step] > input[pos])
        .count();
  }
}
