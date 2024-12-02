package fpc.aoc.year2021.day14;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day14.struct.Counter;
import fpc.aoc.year2021.day14.struct.Input;

public class Day14Part1Solver extends Day14Solver {

  public static Solver provider() {
    return new Day14Part1Solver();
  }

  @Override
  public String doSolve(Input input) {
    final var counter = new Counter(input.template(), input.rules());
    return String.valueOf(counter.compute(10));
  }
}
