package fpc.aoc.year2024.day02;

import fpc.aoc.api.Solver;

import java.util.stream.Stream;

public class Day2Part2Solver extends Day2Solver {

  public static Solver provider() {
    return new Day2Part2Solver();
  }

  @Override
  protected Object doSolve(Stream<Report> input) {
    return input.filter(Report::isSafePart2).count();
  }
}
