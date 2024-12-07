package fpc.aoc.year2024.day07;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
public abstract class Day7Solver extends SmartSolver<Stream<Line>> {

  @Override
  protected Converter<Stream<Line>> getConverter() {
    return Converter.forStreamOfItems(Line::parse);
  }

  @Override
  protected final Object doSolve(Stream<Line> input) {
    final var operators = getAllowedOperators();
    return input
        .filter(l -> l.canBeTrueWith(operators))
        .mapToLong(Line::resultAsLong)
        .sum();
  }

  protected abstract List<Operator> getAllowedOperators();

}
