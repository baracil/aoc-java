package fpc.aoc.year2022.day23;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day23Part2Solver extends Day23Solver {

  public static @NonNull Solver provider() {
    return new Day23Part2Solver();
  }


  @Override
  public @NonNull Integer doSolve(@NonNull Elves input) {
    var current = input;
    int nbRound = 0;
    do {
      current = current.performOneRound();
      nbRound++;
    } while (!current.allIsolated());
    return nbRound;
  }
}
