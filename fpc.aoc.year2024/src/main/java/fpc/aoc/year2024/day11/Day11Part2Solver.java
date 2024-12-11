package fpc.aoc.year2024.day11;

import fpc.aoc.api.Solver;

public class Day11Part2Solver extends Day11Solver {

  public static Solver provider() {
    return new Day11Part2Solver();
  }

  @Override
  protected int getNbBlinks() {
    return 75;
  }
}
