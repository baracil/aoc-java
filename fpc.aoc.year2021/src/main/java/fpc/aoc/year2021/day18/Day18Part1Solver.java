package fpc.aoc.year2021.day18;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day18.struct.Number;

import java.util.stream.Stream;

public class Day18Part1Solver extends Day18Solver {

  public static Solver provider() {
    return new Day18Part1Solver();
  }

  @Override
  public Long doSolve(Stream<Number> input) {
    return input.reduce(Number.NIL, Number::add).magnitude();
  }
}
