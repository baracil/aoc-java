package fpc.aoc.year2024.day02;

import fpc.aoc.api.Solver;

import java.util.stream.Stream;

public class Day2Part1Solver extends Day2Solver {

  public static Solver provider() {
    return new Day2Part1Solver();
  }

  @Override
  protected Object doSolve(Stream<Report> input) {
    return input.filter(Report::isSafePart1).count();
  }
}
