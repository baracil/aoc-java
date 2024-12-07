package fpc.aoc.year2024.day07;

import fpc.aoc.api.Solver;

import java.util.List;

public class Day7Part1Solver extends Day7Solver {

  public static Solver provider() {
    return new Day7Part1Solver();
  }

  @Override
  protected List<Operator> getAllowedOperators() {
    return List.of(Operator.ADDITION,Operator.MULTIPLICATION);
  }
}
