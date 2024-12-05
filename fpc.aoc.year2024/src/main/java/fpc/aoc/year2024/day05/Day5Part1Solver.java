package fpc.aoc.year2024.day05;

import fpc.aoc.api.Solver;

import java.util.List;

public class Day5Part1Solver extends Day5Solver {

  public static Solver provider() {
    return new Day5Part1Solver();
  }

  @Override
  protected Object doSolve(List<Update> updates, Contraints contraints) {
    return updates.stream().filter(u -> u.isInCorrectOrder(contraints))
        .map(Update::getMiddlePage)
        .mapToInt(PageNumber::value)
        .sum();
  }
}
