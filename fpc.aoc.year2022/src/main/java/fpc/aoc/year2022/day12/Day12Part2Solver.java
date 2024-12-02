package fpc.aoc.year2022.day12;

import fpc.aoc.api.Solver;

public class Day12Part2Solver extends Day12Solver {

  public static Solver provider() {
    return new Day12Part2Solver();
  }

  public Day12Part2Solver() {
    super(new Part2PathInfo());
  }
}
