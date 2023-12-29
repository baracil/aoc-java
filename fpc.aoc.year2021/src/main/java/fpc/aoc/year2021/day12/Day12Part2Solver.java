package fpc.aoc.year2021.day12;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day12.struct.Part2RecursiveMode;
import fpc.aoc.year2021.day12.struct.RecursiveMode;
import lombok.NonNull;

public class Day12Part2Solver extends Day12Solver {

  public static @NonNull Solver provider() {
    return new Day12Part2Solver();
  }

  @Override
  protected RecursiveMode getRecursiveMode() {
    return new Part2RecursiveMode();
  }
}
