package fpc.aoc.year2022.day11;

import fpc.aoc.api.Solver;

import java.util.List;
import java.util.function.LongUnaryOperator;

public class Day11Part1Solver extends Day11Solver {

  public static Solver provider() {
    return new Day11Part1Solver();
  }


  @Override
  protected int getNumberOfTurns() {
    return 20;
  }

  @Override
  protected LongUnaryOperator createPostOperation(List<ParsedMonkey> parsedMonkeys) {
    return i -> i / 3;
  }
}
