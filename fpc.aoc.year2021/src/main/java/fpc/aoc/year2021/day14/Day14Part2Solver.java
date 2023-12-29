package fpc.aoc.year2021.day14;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day14.struct.Counter;
import fpc.aoc.year2021.day14.struct.Input;
import lombok.NonNull;

public class Day14Part2Solver extends Day14Solver {

  public static @NonNull Solver provider() {
    return new Day14Part2Solver();
  }

  @Override
  public @NonNull String doSolve(@NonNull Input input) {
    final var counter = new Counter(input.template(), input.rules());
    return String.valueOf(counter.compute(40));
  }

}
