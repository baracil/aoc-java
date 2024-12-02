package fpc.aoc.year2023.day04;

import fpc.aoc.api.Solver;

import java.util.List;

public class Day4Part1Solver extends Day4Solver {

  public static Solver provider() {
    return new Day4Part1Solver();
  }

  @Override
  public Object doSolve(List<Card> input) {
    return String.valueOf(input.stream().mapToInt(Card::score).sum());
  }
}
