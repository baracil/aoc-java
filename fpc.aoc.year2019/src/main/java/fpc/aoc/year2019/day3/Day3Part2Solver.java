package fpc.aoc.year2019.day3;

import fpc.aoc.api.Solver;

public class Day3Part2Solver extends BaseDay3Solver {

  public static Solver provider() {
    return new Day3Part2Solver();
  }

  @Override
  protected int compute(Path path1, Path path2) {
    return Path.intersectionStream(path1, path2)
        .mapToInt(pt -> path1.numberOfStepsToReach(pt) + path2.numberOfStepsToReach(pt))
        .min()
        .orElseThrow();
  }
}
