package fpc.aoc.year2022.day23;

import fpc.aoc.api.Solver;

public class Day23Part1Solver extends Day23Solver {

  public static Solver provider() {
    return new Day23Part1Solver();
  }

  @Override
  public Integer doSolve(Elves elves) {
    var current = elves;
    for (int i = 0; i < 10; i++) {
      current = current.performOneRound();
    }
    return current.nbEmptyGrounds();
  }
}
