package fpc.aoc.year2023.day06;

import fpc.aoc.api.Solver;

import java.util.List;

public class Day6Part1Solver extends Day6Solver {

  public static Solver provider() {
    return new Day6Part1Solver();
  }


  @Override
  public Object doSolve(List<String> input) {

    return Race.parsePart1(input).stream().mapToLong(Race::nbWins)
        .reduce(1, (i1, i2) -> i1 * i2);
  }
}
