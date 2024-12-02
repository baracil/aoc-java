package fpc.aoc.year2022.day5;

import fpc.aoc.api.Solver;

public class Day5Part1Solver extends Day5Solver {

  public static Solver provider() {
    return new Day5Part1Solver();
  }

  public Day5Part1Solver() {
    super(new CrateMover9000());
  }
}
