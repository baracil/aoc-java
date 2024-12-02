package fpc.aoc.year2023.day11;

import fpc.aoc.api.Solver;
import fpc.aoc.common.ArrayOfChar;

public class Day11Part1Solver extends Day11Solver {

  public static Solver provider() {
    return new Day11Part1Solver();
  }


  @Override
  public Object doSolve(ArrayOfChar input) {
    return Computer.find(input, 2);
  }
}
