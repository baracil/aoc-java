package fpc.aoc.year2021.day17;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day17.struct.ProbeTester;
import fpc.aoc.year2021.day17.struct.Target;
import fpc.aoc.year2021.day17.struct.Vec;

public class Day17Part1Solver extends Day17Solver {

  public static Solver provider() {
    return new Day17Part1Solver();
  }

  @Override
  public Long doSolve(Target input) {
    final var tester = new ProbeTester(input);
    final var maxy = input.searchSpace()
        .filter(tester::willReach)
        .mapToInt(Vec::y)
        .max()
        .orElseThrow();
    return maxy * (maxy + 1L) / 2;
  }
}
