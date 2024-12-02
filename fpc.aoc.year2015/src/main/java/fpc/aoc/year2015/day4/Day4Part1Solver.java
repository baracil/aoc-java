package fpc.aoc.year2015.day4;

import fpc.aoc.api.Solver;

public class Day4Part1Solver extends Day4Solver {

  public static Solver provider() {
    return new Day4Part1Solver();
  }

  @Override
  public Integer doSolve(String input) {
    return solve(input,0xF0);
  }
}
