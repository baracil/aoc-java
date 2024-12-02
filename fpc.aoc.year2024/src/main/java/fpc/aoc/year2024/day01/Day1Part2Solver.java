package fpc.aoc.year2024.day01;

import fpc.aoc.api.Solver;

import java.util.List;
import java.util.stream.Collectors;

public class Day1Part2Solver extends Day1Solver {

  public static Solver provider() {
    return new Day1Part2Solver();
  }

  @Override
  protected Object doSolve(List<Pair> input) {
    final var count = input.stream().collect(Collectors.groupingBy(Pair::right, Collectors.counting()));
    return input.stream().mapToLong(p -> p.left() * count.getOrDefault(p.left(), 0L)).sum();
  }

}
