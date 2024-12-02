package fpc.aoc.year2022.day14;

import fpc.aoc.api.Solver;

public class Day14Part2Solver extends Day14Solver {

  public static Solver provider() {
    return new Day14Part2Solver();
  }

  public Day14Part2Solver() {
    super(Cave::dropSandPart2);
  }
}
