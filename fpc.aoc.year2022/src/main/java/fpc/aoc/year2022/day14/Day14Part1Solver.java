package fpc.aoc.year2022.day14;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day14Part1Solver extends Day14Solver {

  public static @NonNull Solver provider() {
    return new Day14Part1Solver();
  }

  public Day14Part1Solver() {
    super(Cave::dropSandPart1);
  }
}
