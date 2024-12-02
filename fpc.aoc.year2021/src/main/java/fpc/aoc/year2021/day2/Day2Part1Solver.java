package fpc.aoc.year2021.day2;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Submarine;

public class Day2Part1Solver extends Day2Solver {

  public static Solver provider() {
    return new Day2Part1Solver();
  }

  public Day2Part1Solver() {
    super(Submarine::withStupidCommand);
  }

}
