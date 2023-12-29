package fpc.aoc.year2022.day18;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Day18Solver extends SmartSolver<Set<Face>> {

  @Override
  protected @NonNull Converter<Set<Face>> getConverter() {
    return s -> s.stream().map(Cube::parse)
        .flatMap(Cube::faces)
        .collect(Collectors.groupingBy(f -> f, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(e -> e.getValue() == 1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toSet());
  }
}
