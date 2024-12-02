package fpc.aoc.year2020.day18;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day18.structures.ExpressionEvaluator;
import fpc.aoc.year2020.day18.structures.ExpressionEvaluatorPart1;

public class Day18Part1Solver extends Day18Solver {

  public static Solver provider() {
    return new Day18Part1Solver();
  }

  @Override
  protected ExpressionEvaluator createOnePassEvaluator() {
    return new ExpressionEvaluatorPart1();
  }
}
