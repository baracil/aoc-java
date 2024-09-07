package fpc.aoc.year2015.day18;

import fpc.aoc.api.Solver;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.GameOfLife;
import fpc.aoc.common.Point2D;
import lombok.NonNull;

public class Day18Part1Solver extends Day18Solver {

  public static @NonNull Solver provider() {
    return new Day18Part1Solver();
  }

  @Override
  public @NonNull Integer doSolve(@NonNull ArrayOfChar input) {
    final var gol = GameOfLife.initialize(input,Point2D::new,new Rule(100));

    gol.performCycles(100);
    return gol.numberOfActiveCells();

  }

}
