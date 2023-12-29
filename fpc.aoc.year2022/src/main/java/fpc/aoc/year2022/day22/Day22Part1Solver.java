package fpc.aoc.year2022.day22;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day22Part1Solver extends Day22Solver {

  public static @NonNull Solver provider() {
    return new Day22Part1Solver();
  }

  public Day22Part1Solver() {
    super(NavigationFactory.part1());
  }
}
