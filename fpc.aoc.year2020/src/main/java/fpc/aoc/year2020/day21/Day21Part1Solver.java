package fpc.aoc.year2020.day21;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day21.structures.Guide;

public class Day21Part1Solver extends Day21Solver {

  public static Solver provider() {
    return new Day21Part1Solver();
  }

  @Override
  public Integer doSolve(Guide guide) {

    return guide.safeIngredients()
        .stream()
        .mapToInt(i -> guide.bagOfIngredients().quantity(i))
        .sum();

  }
}
