package fpc.aoc.year2021.day15;

import fpc.aoc.api.Solver;

public class Day15Part2Solver extends Day15Solver {

  public static Solver provider() {
    return new Day15Part2Solver();
  }

  @Override
  protected int getNbRepetitions() {
    return 5;
  }
}
