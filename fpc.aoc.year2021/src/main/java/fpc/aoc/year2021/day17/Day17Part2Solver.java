package fpc.aoc.year2021.day17;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day17.struct.ProbeTester;
import fpc.aoc.year2021.day17.struct.Target;

public class Day17Part2Solver extends Day17Solver {

  public static Solver provider() {
    return new Day17Part2Solver();
  }

  @Override
  public Long doSolve(Target input) {
    final var tester = new ProbeTester(input);
    return input.searchSpace().filter(tester::willReach).count();
  }
}
