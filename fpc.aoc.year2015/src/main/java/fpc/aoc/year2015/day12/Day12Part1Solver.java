package fpc.aoc.year2015.day12;

import fpc.aoc.api.Solver;

import java.util.Map;
import java.util.function.Predicate;

public class Day12Part1Solver extends Day12Solver {

  public static Solver provider() {
    return new Day12Part1Solver();
  }

  @Override
  protected Predicate<Map<?, ?>> getIgnoredPredicate() {
    return m -> false;
  }
}
