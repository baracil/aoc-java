package fpc.aoc.year2021.day12;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day12.struct.Part1RecursiveMode;
import fpc.aoc.year2021.day12.struct.RecursiveMode;

public class Day12Part1Solver extends Day12Solver {

  public static Solver provider() {
    return new Day12Part1Solver();
  }

  @Override
  protected RecursiveMode getRecursiveMode() {
    return new Part1RecursiveMode();
  }
}
