package fpc.aoc.year2015.day8;

import fpc.aoc.api.Solver;

import java.util.stream.Stream;

public class Day8Part2Solver extends Day8Solver {

  public static Solver provider() {
    return new Day8Part2Solver();
  }

  @Override
  protected Object doSolve(Stream<String> input) {
    return input.mapToLong(s -> StrTools.newEncodeLength(s) - StrTools.codeLength(s)).sum();
  }
}
