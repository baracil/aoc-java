package fpc.aoc.year2024.day03;

import fpc.aoc.api.Solver;

public class Day3Part2Solver extends Day3Solver {

  public static Solver provider() {
    return new Day3Part2Solver();
  }

  @Override
  protected Reducer getReducer() {
    return Reducer.reducerForPart2();
  }

}
