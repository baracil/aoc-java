package fpc.aoc.year2023.day06;

import fpc.aoc.api.Solver;

import java.util.List;

public class Day6Part2Solver extends Day6Solver {

  public static Solver provider() {
    return new Day6Part2Solver();
  }


  @Override
  public Object doSolve(List<String> input) {
    return Race.parsePart2(input).nbWins();
  }
}
