package fpc.aoc.year2024.day10;

import fpc.aoc.common.Position;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Day10Solver extends SmartSolver<Map> {

  @Override
  protected Converter<Map> getConverter() {
    return Converter.toArrayOfChar('.').andThen(Map::new);
  }

  @Override
  protected Object doSolve(Map map) {
    return map.findStartingPositions()
        .stream()
        .mapToInt(p -> getValue(map, p))
        .sum();
  }

  protected abstract int getValue(Map map, Position startingPosition);
}
