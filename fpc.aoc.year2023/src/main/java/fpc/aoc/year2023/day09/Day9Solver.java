package fpc.aoc.year2023.day09;

import fpc.aoc.common.Tools;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day9Solver extends SmartSolver<Stream<long[]>> {

  @Override
  protected Converter<Stream<long[]>> getConverter() {
    return s -> s.stream().map(Tools::toArrayOfLong);
  }
}
