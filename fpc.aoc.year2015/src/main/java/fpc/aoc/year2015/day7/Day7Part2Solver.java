package fpc.aoc.year2015.day7;

import fpc.aoc.api.Solver;
import fpc.aoc.year2015.day7.data.Circuit;
import fpc.aoc.year2015.day7.data.CircuitValue;

public class Day7Part2Solver extends Day7Solver {

  public static Solver provider() {
    return new Day7Part2Solver();
  }

  @Override
  public Long doSolve(Circuit input) {
    var value = new CircuitValue(input);
    var b= value.get("a");
    value.resetAndSetTob(b);
    return value.get("a");
  }
}
