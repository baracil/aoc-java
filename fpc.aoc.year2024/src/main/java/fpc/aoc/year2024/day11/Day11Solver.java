package fpc.aoc.year2024.day11;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public abstract class Day11Solver extends SmartSolver<int[]> {

  @Override
  protected Converter<int[]> getConverter() {
    return Converter.FIRST_LINE
        .andThen(l -> Arrays.stream(l.split(" +"))
            .mapToInt(Integer::parseInt).toArray());
  }

  @Override
  protected final Object doSolve(int[] input) {
    final var counter = new Counter(getNbBlinks());
    return counter.count(input);
  }

  protected abstract int getNbBlinks();
}
