package fpc.aoc.year2015.day7;

import fpc.aoc.api.Solver;
import fpc.aoc.year2015.day7.data.Circuit;
import fpc.aoc.year2015.day7.data.CircuitValue;
import lombok.NonNull;

public class Day7Part2Solver extends Day7Solver {

  public static @NonNull Solver provider() {
    return new Day7Part2Solver();
  }

  @Override
  public @NonNull Long doSolve(@NonNull Circuit input) {
    var value = new CircuitValue(input);
    var b= value.get("a");
    value.resetAndSetTob(b);
    return value.get("a");
  }
}
