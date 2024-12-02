package fpc.aoc.year2015.day11;

import fpc.aoc.api.Solver;

public class Day11Part1Solver extends Day11Solver {

  public static Solver provider() {
    return new Day11Part1Solver();
  }

  @Override
  public String doSolve(String input) {
    final var p = Password.of(input);
    do {
      p.increment();
    } while (!p.isValid());
    return p.toString();
  }
}
