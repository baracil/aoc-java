package fpc.aoc.year2015.day8;

import fpc.aoc.api.Solver;

import java.util.stream.Stream;

public class Day8Part1Solver extends Day8Solver {

  public static Solver provider() {
    return new Day8Part1Solver();
  }

  @Override
  protected Object doSolve(Stream<String> input) {
    return input.mapToLong(s -> StrTools.codeLength(s) - StrTools.memoryLength(s)).sum();
  }
}
