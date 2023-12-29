package fpc.aoc.year2022.day9;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day9Part2Solver extends Day9Solver {

  public static @NonNull Solver provider() {
    return new Day9Part2Solver();
  }

  public Day9Part2Solver() {
    super(10);
  }
}
