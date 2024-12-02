package fpc.aoc.year2015.day2;

import fpc.aoc.api.Solver;

import java.util.stream.Stream;

public class Day2Part2Solver extends Day2Solver {

  public static Solver provider() {
    return new Day2Part2Solver();
  }

  @Override
  public Integer doSolve(Stream<Present> presents) {
    return presents.mapToInt(Present::ribbonLength).sum();
  }
}
