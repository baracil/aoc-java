package fpc.aoc.year2024.day07;

import fpc.aoc.api.Solver;

import java.util.List;

public class Day7Part2Solver extends Day7Solver {

  public static Solver provider() {
    return new Day7Part2Solver();
  }

  @Override
  protected List<Operator> getAllowedOperators() {
    return List.of(Operator.ADDITION,Operator.MULTIPLICATION,Operator.CONCATENATION);
  }
}
