package fpc.aoc.year2023.day24;

import fpc.aoc.api.Solver;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day24Part2Solver extends Day24Solver {

  public static Solver provider() {
    return new Day24Part2Solver();
  }

  @Override
  public boolean isSkipped() {
    return true;
  }

  @Override
  public Object doSolve(Stream<String> input) {
    throw new NotSolvedYet();
  }
}
