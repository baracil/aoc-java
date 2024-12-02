package fpc.aoc.year2015.day5;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class Day5Solver extends SmartSolver<Stream<String>> {

  @Override
  protected Converter<Stream<String>> getConverter() {
    return Converter.TO_STREAM;
  }

}
