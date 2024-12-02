package fpc.aoc.year2020.day1;

import fpc.aoc.api.Solver;
import fpc.aoc.common.AOCException;

import java.util.Optional;

public class Day1Part1Solver extends Day1Solver {

  public static Solver provider() {
    return new Day1Part1Solver();
  }

  @Override
  public Integer doSolve(int[] input) {
    final var finder = new ProductFinder();

    for (int value : input) {
      final Optional<Integer> product = finder.onNewValue(value);
      if (product.isPresent()) {
        return product.get();
      }
    }
    throw new AOCException("Cannot find 2 numbers that sum to 2020");
  }

  private static class ProductFinder {

    private final boolean[] seen = new boolean[2021];

    public Optional<Integer> onNewValue(int value) {
      if (value < 0 || value > 2020) {
        return Optional.empty();
      }

      final int complement = 2020 - value;
      if (seen[complement]) {
        return Optional.of(complement * value);
      }

      seen[value] = true;
      return Optional.empty();
    }
  }
}
