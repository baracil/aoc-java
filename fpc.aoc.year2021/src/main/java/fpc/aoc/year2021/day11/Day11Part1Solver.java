package fpc.aoc.year2021.day11;

import fpc.aoc.api.Solver;

public class Day11Part1Solver extends Day11Solver {

  public static Solver provider() {
    return new Day11Part1Solver();
  }

  @Override
  public String doSolve(Map map) {
    for (int i = 0; i < 100; i++) {
      map.executeOneStep();
    }
    return String.valueOf(map.numberOfFlashes());

  }
}
