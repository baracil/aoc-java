package fpc.aoc.year2023.day12;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public abstract class Day12Solver extends SmartSolver<Stream<Row>> {


  @Override
  protected Converter<Stream<Row>> getConverter() {
    return s -> s.stream().map(Row::parse);
  }


  protected abstract Row prepareRow(Row row);

  @Override
  public Object doSolve(Stream<Row> input) {
    return input.map(this::prepareRow).mapToLong(ArrangementCounter::count).sum();
  }
}
