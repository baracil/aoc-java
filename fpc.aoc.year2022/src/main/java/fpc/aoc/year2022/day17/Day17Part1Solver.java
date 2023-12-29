package fpc.aoc.year2022.day17;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day17Part1Solver extends Day17Solver {

  public static @NonNull Solver provider() {
    return new Day17Part1Solver();
  }

  @Override
  public @NonNull Long doSolve(@NonNull Game game) {
    for (int i = 0; i < 2022; i++) {
      game.fallOnePiece();
    }
    return game.getTowerHeight();
  }

}
