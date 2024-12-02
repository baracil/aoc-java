package fpc.aoc.year2015.day7;

import fpc.aoc.api.Solver;
import fpc.aoc.year2015.day7.data.CircuitValue;

public class Day7Part1Solver extends Day7Solver {

  public static Solver provider() {
    return new Day7Part1Solver();
  }

  @Override
  protected Object doSolve(fpc.aoc.year2015.day7.data.Circuit input) {
    var value = new CircuitValue(input);
    return value.get("a");
  }
}
