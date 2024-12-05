package fpc.aoc.year2024.day05;

import fpc.aoc.api.Solver;

import java.util.List;

public class Day5Part2Solver extends Day5Solver {

  public static Solver provider() {
    return new Day5Part2Solver();
  }

  @Override
  protected Object doSolve(List<Update> updates, Contraints contraints) {
    return updates.stream()
        .filter(p -> !p.isInCorrectOrder(contraints))
        .map(u -> u.getMiddlePageAfterOrdering(contraints))
        .mapToInt(PageNumber::value)
        .sum();
  }
}
