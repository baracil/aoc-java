package fpc.aoc.year2021.day15;

import fpc.aoc.api.Solver;

public class Day15Part1Solver extends Day15Solver {

  public static Solver provider() {
    return new Day15Part1Solver();
  }

  @Override
  protected int getNbRepetitions() {
    return 1;
  }
}
