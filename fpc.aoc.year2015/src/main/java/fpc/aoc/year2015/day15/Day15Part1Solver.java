package fpc.aoc.year2015.day15;

import fpc.aoc.api.Solver;

import java.util.function.LongPredicate;

public class Day15Part1Solver extends Day15Solver {

  public static Solver provider() {
    return new Day15Part1Solver();
  }

  @Override
  protected LongPredicate getCaloriePredicate() {
    return c -> true;
  }
}
