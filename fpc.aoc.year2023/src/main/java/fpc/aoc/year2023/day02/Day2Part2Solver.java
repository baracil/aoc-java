package fpc.aoc.year2023.day02;

import fpc.aoc.api.Solver;

import java.util.stream.Stream;

public class Day2Part2Solver extends Day2Solver {

  public static Solver provider() {
    return new Day2Part2Solver();
  }


  @Override
  public Object doSolve(Stream<Game> input) {
    return input.mapToInt(Game::computePower).sum();
  }
}
