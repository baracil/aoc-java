package fpc.aoc.year2023.day12;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day12Part2Solver extends Day12Solver {

  public static @NonNull Solver provider() {
    return new Day12Part2Solver();
  }

  @Override
  protected Row prepareRow(Row row) {
    return row.unfold();
  }
}
