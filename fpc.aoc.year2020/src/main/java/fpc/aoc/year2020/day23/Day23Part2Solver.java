package fpc.aoc.year2020.day23;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day23Part2Solver extends Day23Solver {

  public static @NonNull Solver provider() {
    return new Day23Part2Solver();
  }

  @Override
  public @NonNull String doSolve(@NonNull String input) {
    final var circle = new CupCircle(input, 1_000_000);
    circle.performMoves(10_000_000);
    return circle.part2Result();
  }
}
