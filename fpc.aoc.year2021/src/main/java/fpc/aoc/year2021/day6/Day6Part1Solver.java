package fpc.aoc.year2021.day6;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day6.struct.School;

public class Day6Part1Solver extends Day6Solver {

  public static Solver provider() {
    return new Day6Part1Solver();
  }

  @Override
  public String doSolve(School input) {
    return input.compute_population(GEN_80).toString();
  }
}
