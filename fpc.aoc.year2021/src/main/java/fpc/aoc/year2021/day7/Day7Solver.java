package fpc.aoc.year2021.day7;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.Arrays;

public abstract class Day7Solver extends SmartSolver<int[]> {

  @Override
  protected Converter<int[]> getConverter() {
    return Converter.FIRST_LINE.andThen(this::toArrayOfInt);
  }

  private int[] toArrayOfInt(String line) {
    return Arrays.stream(line.split(","))
        .mapToInt(Integer::parseInt)
        .toArray();
  }
}
