package fpc.aoc.year2020.day23;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day23Part1Solver extends Day23Solver {

  public static @NonNull Solver provider() {
    return new Day23Part1Solver();
  }

  @Override
  public @NonNull String doSolve(@NonNull String input) {
    final var circle = new CupCircle(input);
    circle.performMoves(100);
    return circle.part1Result();
  }
}
