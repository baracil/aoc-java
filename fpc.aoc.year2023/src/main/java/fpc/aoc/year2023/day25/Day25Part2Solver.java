package fpc.aoc.year2023.day25;

import fpc.aoc.api.Solver;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day25Part2Solver extends Day25Solver {

  public static Solver provider() {
    return new Day25Part2Solver();
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
