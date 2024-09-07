package fpc.aoc.year2015.day16;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day16Part2Solver extends Day16Solver {

  public static @NonNull Solver provider() {
    return new Day16Part2Solver();
  }

  @Override
  protected TestFactory createTestFactory() {
    return new TestFactory.Part2();
  }
}
