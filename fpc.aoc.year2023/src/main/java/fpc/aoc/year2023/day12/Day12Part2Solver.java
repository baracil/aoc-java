package fpc.aoc.year2023.day12;

import fpc.aoc.api.Solver;

public class Day12Part2Solver extends Day12Solver {

  public static Solver provider() {
    return new Day12Part2Solver();
  }

  @Override
  protected Row prepareRow(Row row) {
    return row.unfold();
  }
}
