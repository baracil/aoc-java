package fpc.aoc.year2023.day04;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.List;

public class Day4Part1Solver extends Day4Solver {

  public static @NonNull Solver provider() {
    return new Day4Part1Solver();
  }

  @Override
  public @NonNull Object doSolve(@NonNull List<Card> input) {
    return String.valueOf(input.stream().mapToInt(Card::score).sum());
  }
}
