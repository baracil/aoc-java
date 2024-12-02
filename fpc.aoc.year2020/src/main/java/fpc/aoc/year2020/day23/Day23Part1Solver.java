package fpc.aoc.year2020.day23;

import fpc.aoc.api.Solver;

public class Day23Part1Solver extends Day23Solver {

  public static Solver provider() {
    return new Day23Part1Solver();
  }

  @Override
  public String doSolve(String input) {
    final var circle = new CupCircle(input);
    circle.performMoves(100);
    return circle.part1Result();
  }
}
