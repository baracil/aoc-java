package fpc.aoc.year2020.day15;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day15Part1Solver extends Day15Solver {

  public static @NonNull Solver provider() {
    return new Day15Part1Solver();
  }

  @Override
  protected int getNumberOfTurns() {
    return 2020;
  }
}
