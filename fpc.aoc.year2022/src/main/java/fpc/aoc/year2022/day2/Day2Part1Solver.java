package fpc.aoc.year2022.day2;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day2Part1Solver extends Day2Solver {

  public static @NonNull Solver provider() {
    return new Day2Part1Solver();
  }

  public Day2Part1Solver() {
    super(Turn::forPart1);
  }

}
