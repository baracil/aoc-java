package fpc.aoc.year2015.day15;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.function.LongPredicate;

public class Day15Part2Solver extends Day15Solver {

  public static @NonNull Solver provider() {
    return new Day15Part2Solver();
  }

  @Override
  protected LongPredicate getCaloriePredicate() {
    return c -> c == 500;
  }
}
