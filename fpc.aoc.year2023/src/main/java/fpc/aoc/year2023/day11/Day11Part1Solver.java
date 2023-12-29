package fpc.aoc.year2023.day11;

import fpc.aoc.api.Solver;
import fpc.aoc.common.ArrayOfChar;
import lombok.NonNull;

public class Day11Part1Solver extends Day11Solver {

  public static @NonNull Solver provider() {
    return new Day11Part1Solver();
  }


  @Override
  public @NonNull Object doSolve(@NonNull ArrayOfChar input) {
    return Computer.find(input, 2);
  }
}
