package fpc.aoc.year2022.day5;

import fpc.aoc.api.Solver;

public class Day5Part2Solver extends Day5Solver {

  public static Solver provider() {
    return new Day5Part2Solver();
  }

  public Day5Part2Solver() {
    super(new CrateMover9001());
  }
}
