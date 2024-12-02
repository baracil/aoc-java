package fpc.aoc.year2024.day01;

import fpc.aoc.api.Solver;

import java.util.List;
import java.util.function.ToIntFunction;

public class Day1Part1Solver extends Day1Solver {

  public static Solver provider() {
    return new Day1Part1Solver();
  }

  @Override
  protected Object doSolve(List<Pair> input) {
    final var leftOrdered = getOrder(input, Pair::left);
    final var rightOrdered = getOrder(input, Pair::right);

    int sum = 0;
    for (int i = 0; i < input.size(); i++) {
      sum+=Math.abs(leftOrdered[i] - rightOrdered[i]);
    }

    return sum;
  }

  private int[] getOrder(List<Pair> pairs, ToIntFunction<Pair> valueGetter) {
    return pairs.stream()
        .mapToInt(valueGetter)
        .sorted().toArray();
  }
}
