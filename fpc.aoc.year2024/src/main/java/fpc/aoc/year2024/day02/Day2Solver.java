package fpc.aoc.year2024.day02;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class Day2Solver extends SmartSolver<Stream<Report>> {

  @Override
  protected Converter<Stream<Report>> getConverter() {
    return Converter.forStreamOfItems(Report::parse);
  }


}
