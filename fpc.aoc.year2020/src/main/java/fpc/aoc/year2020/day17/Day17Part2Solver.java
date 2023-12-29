package fpc.aoc.year2020.day17;

import fpc.aoc.api.Solver;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.GameOfLife;
import lombok.NonNull;

public class Day17Part2Solver extends Day17Solver {

  public static @NonNull Solver provider() {
    return new Day17Part2Solver();
  }

  @Override
  protected GameOfLife<?> createGameOfLife(@NonNull ArrayOfChar input) {
    return GameOfLife.initialize(input, (x, y) -> Point4D.of(x, y, 0, 0));
  }
}
