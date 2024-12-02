package fpc.aoc.year2021.day9;

import fpc.aoc.api.Solver;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Day9Part2Solver extends Day9Solver {

  public static Solver provider() {
    return new Day9Part2Solver();
  }


  @Override
  public Integer doSolve(Map map) {
    return map.computePart2Result();
  }
}
