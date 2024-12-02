package fpc.aoc.year2015.day1;

import fpc.aoc.api.Solver;
import fpc.aoc.common.AOCException;

public class Day1Part2Solver extends Day1Solver {

  public static Solver provider() {
    return new Day1Part2Solver();
  }

  @Override
  public Integer doSolve(String input) {
    int pos = 0;
    for (int j = 0; j < input.length(); j++) {
      pos += input.charAt(j)=='('?1:-1;
      if (pos == -1) {
        return j+1;
      }
    }
    throw new AOCException("Cannot solve it");
  }
}
