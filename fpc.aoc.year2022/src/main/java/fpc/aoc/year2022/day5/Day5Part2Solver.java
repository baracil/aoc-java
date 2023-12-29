package fpc.aoc.year2022.day5;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day5Part2Solver extends Day5Solver {

  public static @NonNull Solver provider() {
    return new Day5Part2Solver();
  }

  public Day5Part2Solver() {
    super(new CrateMover9001());
  }
}
