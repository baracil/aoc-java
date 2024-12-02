package fpc.aoc.year2015.day2;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class Day2Solver extends SmartSolver<Stream<Present>> {

  @Override
  protected Converter<Stream<Present>> getConverter() {
    return Converter.forStreamOfItems(Present::parse);
  }

}
