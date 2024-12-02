package fpc.aoc.year2022.day12;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Day12Solver extends SmartSolver<ArrayOfChar> {

  @Override
  protected Converter<ArrayOfChar> getConverter() {
    return Converter.TO_ARRAY_OF_CHAR;
  }

  private final PathInfo pathInfo;


  @Override
  public Object doSolve(ArrayOfChar input) {
    final var pathFinder = new PathFinder(input, pathInfo);
    final var path = pathFinder.findShortestPath();
    return path.nbSteps();

  }

}
