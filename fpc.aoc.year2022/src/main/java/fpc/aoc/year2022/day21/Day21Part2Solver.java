package fpc.aoc.year2022.day21;

import fpc.aoc.api.Solver;

public class Day21Part2Solver extends Day21Solver<Op> {

  public static Solver provider() {
    return new Day21Part2Solver();
  }

  public Day21Part2Solver() {
    super(new MonkeyEvaluatorPart2());
  }

  @Override
  protected Long finalize(Op rootResult) {
    return rootResult.toGetZero().round();
  }

}
