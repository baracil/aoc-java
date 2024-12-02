package fpc.aoc.year2021.day6;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day6.struct.School;

public class Day6Part2Solver extends Day6Solver {

  public static Solver provider() {
    return new Day6Part2Solver();
  }

  @Override
  public String doSolve(School input) {
    return input.compute_population(GEN_256).toString();
  }
}
