package fpc.aoc.year2015.day17;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day17Part1Solver extends Day17Solver {

  public static @NonNull Solver provider() {
    return new Day17Part1Solver();
  }

  @Override
  protected @NonNull Object doSolve(int @NonNull [] input) {
    return SolverPart1.solve(150, input);
  }
}
