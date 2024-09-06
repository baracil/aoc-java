package fpc.aoc.year2019.day1;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.IntStream;

public abstract class Day1Solver extends SmartSolver<IntStream> {

  @Override
  protected @NonNull
  Converter<IntStream> getConverter() {
    return Converter.TO_INT_STREAM;
  }


}
