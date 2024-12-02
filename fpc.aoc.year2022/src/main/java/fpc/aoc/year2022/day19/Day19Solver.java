package fpc.aoc.year2022.day19;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class Day19Solver extends SmartSolver<Stream<BluePrint>> {

  @Override
  protected Converter<Stream<BluePrint>> getConverter() {
    return s -> s.stream().map(BluePrint::parse);
  }


}
