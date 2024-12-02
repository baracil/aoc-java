package fpc.aoc.year2021.day10;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day10.structures.SyntaxChecker;

import java.util.stream.Stream;

public class Day10Part1Solver extends Day10Solver {

  public static Solver provider() {
    return new Day10Part1Solver();
  }

  @Override
  public Integer doSolve(Stream<String> input) {
    return input.mapToInt(SyntaxChecker.create()::check)
        .sum();
  }
}
