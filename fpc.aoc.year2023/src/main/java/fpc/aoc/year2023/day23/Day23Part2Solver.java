package fpc.aoc.year2023.day23;

import fpc.aoc.api.Solver;
import fpc.aoc.common.NotSolvedYet;

import java.util.stream.Stream;

public class Day23Part2Solver extends Day23Solver {

  public static Solver provider() {
    return new Day23Part2Solver();
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
