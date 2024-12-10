package fpc.aoc.year2024.day10;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Position;

public class Day10Part1Solver extends Day10Solver {

  public static Solver provider() {
    return new Day10Part1Solver();
  }

  @Override
  protected int getValue(Map map, Position startingPosition) {
    return ValueCalculator.computeScore(map, startingPosition);
  }
}
