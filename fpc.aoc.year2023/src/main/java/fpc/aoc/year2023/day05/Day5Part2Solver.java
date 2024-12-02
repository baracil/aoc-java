package fpc.aoc.year2023.day05;

import fpc.aoc.api.Solver;
import fpc.aoc.year2023.day05.data.Input;
import fpc.aoc.year2023.day05.data.Range;

public class Day5Part2Solver extends Day5Solver {

  public static Solver provider() {
    return new Day5Part2Solver();
  }


  @Override
  public Object doSolve(Input input) {
    var ranges = input.map(input.seeds2());

    final var min = ranges.stream().mapToLong(Range::start).min().orElse(0);

    return String.valueOf(min);

  }
}
