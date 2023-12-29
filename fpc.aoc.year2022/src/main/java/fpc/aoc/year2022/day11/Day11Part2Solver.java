package fpc.aoc.year2022.day11;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.List;
import java.util.function.LongUnaryOperator;

public class Day11Part2Solver extends Day11Solver {

  public static @NonNull Solver provider() {
    return new Day11Part2Solver();
  }


  @Override
  protected int getNumberOfTurns() {
    return 10_000;
  }

  @Override
  protected LongUnaryOperator createPostOperation(@NonNull List<ParsedMonkey> parsedMonkeys) {
    final var mod = parsedMonkeys.stream().mapToInt(ParsedMonkey::divisor).reduce(1, (a, b) -> a * b);
    return i -> i % mod;
  }
}
