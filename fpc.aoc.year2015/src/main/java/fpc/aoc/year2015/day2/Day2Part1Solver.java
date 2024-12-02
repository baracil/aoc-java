package fpc.aoc.year2015.day2;

import fpc.aoc.api.Solver;

import java.util.stream.Stream;

public class Day2Part1Solver extends Day2Solver {

  public static Solver provider() {
    return new Day2Part1Solver();
  }


  @Override
  public Integer doSolve(Stream<Present> presents) {
    return presents.mapToInt(Present::paperArea).sum();
  }
}
