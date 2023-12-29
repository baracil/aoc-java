package fpc.aoc.year2020.day17;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.GameOfLife;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day17Solver extends SmartSolver<ArrayOfChar> {

  @Override
  protected @NonNull Converter<ArrayOfChar> getConverter() {
    return Converter.TO_ARRAY_OF_CHAR;
  }

  protected abstract GameOfLife<?> createGameOfLife(@NonNull ArrayOfChar input);

  @Override
  public final @NonNull Integer doSolve(@NonNull ArrayOfChar input) {
    final var gameOfLife = createGameOfLife(input);
    gameOfLife.performCycles(6);
    return gameOfLife.numberOfActiveCells();
  }
}
