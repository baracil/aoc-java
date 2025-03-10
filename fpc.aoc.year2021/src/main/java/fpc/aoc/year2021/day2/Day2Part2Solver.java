package fpc.aoc.year2021.day2;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Submarine;

public class Day2Part2Solver extends Day2Solver {

  public static Solver provider() {
    return new Day2Part2Solver();
  }

  public Day2Part2Solver() {
    super(Submarine::withCommand);
  }

}
