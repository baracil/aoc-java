package fpc.aoc.year2022.day18;

import fpc.aoc.api.Solver;

import java.util.Set;

public class Day18Part1Solver extends Day18Solver {

  public static Solver provider() {
    return new Day18Part1Solver();
  }

  @Override
  public Integer doSolve(Set<Face> input) {
    return input.size();
  }
}
