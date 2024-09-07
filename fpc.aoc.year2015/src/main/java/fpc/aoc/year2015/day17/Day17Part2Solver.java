package fpc.aoc.year2015.day17;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day17Part2Solver extends Day17Solver {

  public static @NonNull Solver provider() {
    return new Day17Part2Solver();
  }

  @Override
  public @NonNull Integer doSolve(int @NonNull [] input) {
    return SolverPart2.solve(150, input);
  }
}
