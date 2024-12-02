package fpc.aoc.year2022.day17;

import fpc.aoc.api.Solver;

public class Day17Part1Solver extends Day17Solver {

  public static Solver provider() {
    return new Day17Part1Solver();
  }

  @Override
  public Long doSolve(Game game) {
    for (int i = 0; i < 2022; i++) {
      game.fallOnePiece();
    }
    return game.getTowerHeight();
  }

}
