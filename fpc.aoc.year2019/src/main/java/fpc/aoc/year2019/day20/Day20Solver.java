package fpc.aoc.year2019.day20;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2019.day20._private.Maze;

public abstract class Day20Solver extends SmartSolver<Maze> {


  @Override
  protected Converter<Maze> getConverter() {
    return Converter.toArrayOfChar(' ').andThen(this::buildMaze);
  }

  @Override
  protected Object doSolve(Maze maze) {
    return maze.findPathLength();
  }


  abstract Maze buildMaze(ArrayOfChar input);
}
