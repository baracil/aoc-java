package fpc.aoc.year2020.day19;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day19.structures.Day19Input;

public class Day19Part1Solver extends Day19Solver {

  public static Solver provider() {
    return new Day19Part1Solver();
  }

  @Override
  protected Day19Input modifyInput(Day19Input input) {
    return input;
  }
}
