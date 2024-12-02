package fpc.aoc.year2023.day10;

import fpc.aoc.api.Solver;

public class Day10Part1Solver extends Day10Solver {

  public static Solver provider() {
    return new Day10Part1Solver();
  }


  @Override
  public Object doSolve(Map input) {
    final var cycle = input.cycle();
    return cycle.size() / 2;
  }
}
