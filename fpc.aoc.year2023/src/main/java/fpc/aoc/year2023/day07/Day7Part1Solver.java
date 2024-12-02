package fpc.aoc.year2023.day07;

import fpc.aoc.api.Solver;
import fpc.aoc.year2023.day07.model.HandParser;

public class Day7Part1Solver extends Day7Solver {

  public static Solver provider() {
    return new Day7Part1Solver();
  }

  @Override
  protected HandParser createHandParser() {
    return HandParser.forPart1();
  }
}
