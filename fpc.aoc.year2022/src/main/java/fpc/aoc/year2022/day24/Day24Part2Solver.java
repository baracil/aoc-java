package fpc.aoc.year2022.day24;

import fpc.aoc.api.Solver;

public class Day24Part2Solver extends Day24Solver {

  public static Solver provider() {
    return new Day24Part2Solver();
  }


  @Override
  public Object doSolve(Map input) {
    return PathFinder.findPathPart2(input).turn();
  }
}
