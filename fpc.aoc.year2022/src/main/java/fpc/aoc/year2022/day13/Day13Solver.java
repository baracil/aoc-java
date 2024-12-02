package fpc.aoc.year2022.day13;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public abstract class Day13Solver extends SmartSolver<List<PairOfItem>> {

  @Override
  protected Converter<List<PairOfItem>> getConverter() {
    return s -> {
      final var list = s.stream()
          .filter(Predicate.not(String::isEmpty))
          .map(ItemParserWithStack::parse)
          .toList();
      return IntStream.iterate(0, i -> i < list.size(), i -> i + 2)
          .mapToObj(i -> new PairOfItem(i / 2 + 1, list.get(i), list.get(i + 1)))
          .toList();
    };
  }
}
