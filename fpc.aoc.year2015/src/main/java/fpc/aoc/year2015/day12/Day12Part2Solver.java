package fpc.aoc.year2015.day12;

import fpc.aoc.api.Solver;

import java.util.Map;
import java.util.function.Predicate;

public class Day12Part2Solver extends Day12Solver {

  public static Solver provider() {
    return new Day12Part2Solver();
  }

  @Override
  protected Predicate<Map<?, ?>> getIgnoredPredicate() {
    return m -> {
      for (Object value : m.values()) {
        if ("red".equals(value)) {
          return true;
        }
      }
      return false;
    };
  }
}
