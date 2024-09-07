package fpc.aoc.year2015.day7;

import fpc.aoc.api.Solver;
import fpc.aoc.year2015.day7.data.CircuitValue;
import lombok.NonNull;

public class Day7Part1Solver extends Day7Solver {

  public static @NonNull Solver provider() {
    return new Day7Part1Solver();
  }

  @Override
  protected @NonNull Object doSolve(fpc.aoc.year2015.day7.data.@NonNull Circuit input) {
    var value = new CircuitValue(input);
    return value.get("a");
  }
}
