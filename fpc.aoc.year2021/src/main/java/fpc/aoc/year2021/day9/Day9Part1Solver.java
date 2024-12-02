package fpc.aoc.year2021.day9;

import fpc.aoc.api.Solver;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Day9Part1Solver extends Day9Solver {

  public static Solver provider() {
    return new Day9Part1Solver();
  }

  @Override
  public Integer doSolve(Map map) {
    return map.computePart1Result();
  }
}
