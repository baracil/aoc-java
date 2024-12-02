package fpc.aoc.year2020.day17;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.GameOfLife;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

public abstract class Day17Solver extends SmartSolver<ArrayOfChar> {

  @Override
  protected Converter<ArrayOfChar> getConverter() {
    return Converter.TO_ARRAY_OF_CHAR;
  }

  protected abstract GameOfLife<?> createGameOfLife(ArrayOfChar input);

  @Override
  public final Integer doSolve(ArrayOfChar input) {
    final var gameOfLife = createGameOfLife(input);
    gameOfLife.performCycles(6);
    return gameOfLife.numberOfActiveCells();
  }
}
