package fpc.aoc.year2019.day20;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2019.day20._private.Maze;
import lombok.NonNull;

public abstract class Day20Solver extends SmartSolver<Maze> {


  @Override
  protected @NonNull Converter<Maze> getConverter() {
    return Converter.toArrayOfChar(' ').andThen(this::buildMaze);
  }

  @Override
  protected @NonNull Object doSolve(@NonNull Maze maze) {
    return maze.findPathLength();
  }


  abstract Maze buildMaze(ArrayOfChar input);
}
