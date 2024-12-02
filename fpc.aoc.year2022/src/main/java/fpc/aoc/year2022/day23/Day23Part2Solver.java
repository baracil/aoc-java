package fpc.aoc.year2022.day23;

import fpc.aoc.api.Solver;

public class Day23Part2Solver extends Day23Solver {

  public static Solver provider() {
    return new Day23Part2Solver();
  }


  @Override
  public Integer doSolve(Elves input) {
    var current = input;
    int nbRound = 0;
    do {
      current = current.performOneRound();
      nbRound++;
    } while (!current.allIsolated());
    return nbRound;
  }
}
