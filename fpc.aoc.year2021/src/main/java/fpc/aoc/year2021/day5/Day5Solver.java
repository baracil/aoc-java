package fpc.aoc.year2021.day5;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2021.day5.struct.Vent;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Day5Solver extends SmartSolver<Stream<Vent>> {

  @Override
  protected Converter<Stream<Vent>> getConverter() {
    return s -> s.stream().map(Vent::parse);
  }

  public String doSolve(Stream<Vent> input, Predicate<Vent> ventFilter) {
    final var overlaps = input
        .filter(ventFilter)
        .flatMap(Vent::line)
        .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

    return String.valueOf(overlaps.values().stream().filter(o -> o > 1).count());

  }
}
