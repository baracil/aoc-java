package fpc.aoc.year2020.day18;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day18.structures.ExpressionEvaluator;
import fpc.aoc.year2020.day18.structures.ExpressionEvaluatorPart2;
import lombok.NonNull;

public class Day18Part2Solver extends Day18Solver {

  public static @NonNull Solver provider() {
    return new Day18Part2Solver();
  }

  @Override
  protected @NonNull ExpressionEvaluator createOnePassEvaluator() {
    return new ExpressionEvaluatorPart2();
  }
}
