package fpc.aoc.year2021.day7;

import fpc.aoc.api.Solver;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class Day7Part2Solver extends Day7Solver {

  public static Solver provider() {
    return new Day7Part2Solver();
  }

  @Override
  public Integer doSolve(int[] input) {
    final var mean = Arrays.stream(input).average().orElseThrow();
    final var targetInf = (int) Math.floor(mean);
    final var targetSup = (int) Math.ceil(mean);

    final IntUnaryOperator fueldComputer = target -> Arrays.stream(input).map(i -> computeFuel(i, target)).sum();

    return IntStream.of(targetInf, targetSup).map(fueldComputer).min().orElse(0);
  }

  private int computeFuel(int position, int target) {
    final var dif = Math.abs(position - target);
    return dif * (dif + 1) / 2;
  }
}
