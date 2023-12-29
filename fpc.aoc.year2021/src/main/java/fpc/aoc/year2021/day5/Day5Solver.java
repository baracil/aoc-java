package fpc.aoc.year2021.day5;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2021.day5.struct.Vent;
import lombok.NonNull;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Day5Solver extends SmartSolver<Stream<Vent>> {

  @Override
  protected @NonNull Converter<Stream<Vent>> getConverter() {
    return s -> s.stream().map(Vent::parse);
  }

  public @NonNull String doSolve(@NonNull Stream<Vent> input, @NonNull Predicate<Vent> ventFilter) {
    final var overlaps = input
        .filter(ventFilter)
        .flatMap(Vent::line)
        .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

    return String.valueOf(overlaps.values().stream().filter(o -> o > 1).count());

  }
}
