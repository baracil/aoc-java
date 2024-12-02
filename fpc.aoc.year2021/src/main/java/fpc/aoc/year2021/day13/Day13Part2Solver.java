package fpc.aoc.year2021.day13;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day13.struct.Input;
import fpc.aoc.year2021.day13.struct.Sheet;

public class Day13Part2Solver extends Day13Solver {

  public static Solver provider() {
    return new Day13Part2Solver();
  }

  @Override
  public String doSolve(Input input) {
    final var sheet = input.folds()
        .stream()
        .reduce(input.sheet(), Sheet::fold, (s1, s2) -> {
          throw new UnsupportedOperationException();
        });

    return sheet.toDisplay();
  }

}
