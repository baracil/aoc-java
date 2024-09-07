package fpc.aoc.year2015.day14;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day14Solver extends SmartSolver<Stream<Reindeer>> {

  @Override
  protected @NonNull Converter<Stream<Reindeer>> getConverter() {
    return Converter.forStreamOfItems(Reindeer::parse);
  }
}
