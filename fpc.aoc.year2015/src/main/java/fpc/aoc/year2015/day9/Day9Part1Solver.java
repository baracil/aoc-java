package fpc.aoc.year2015.day9;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day9Part1Solver extends Day9Solver {

  public static @NonNull Solver provider() {
    return new Day9Part1Solver();
  }

  @Override
  protected @NonNull Object doSolve(@NonNull Input input) {
    final var s = new ShortedSolver(input);
    for (String city : input.cities()) {
      s.process(city);
    }
    return s.best();
  }


}
