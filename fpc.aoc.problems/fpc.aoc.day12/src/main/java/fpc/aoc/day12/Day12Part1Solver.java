package fpc.aoc.day12;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day12Part1Solver extends Day12Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day12Part1Solver().createProblem();
  }


  @Override
  protected Row prepareRow(Row row) {
    return row;
  }
}
