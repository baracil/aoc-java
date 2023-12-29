package fpc.aoc.year2022.day23;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day23Part1Solver extends Day23Solver {

  public static @NonNull Solver provider() {
    return new Day23Part1Solver();
  }

  @Override
  public @NonNull Integer doSolve(@NonNull Elves elves) {
    var current = elves;
    for (int i = 0; i < 10; i++) {
      current = current.performOneRound();
    }
    return current.nbEmptyGrounds();
  }
}
