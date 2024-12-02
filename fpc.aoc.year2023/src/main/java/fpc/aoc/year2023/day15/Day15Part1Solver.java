package fpc.aoc.year2023.day15;

import fpc.aoc.api.Solver;

import java.util.List;

public class Day15Part1Solver extends Day15Solver {

  public static Solver provider() {
    return new Day15Part1Solver();
  }

  @Override
  public Object doSolve(List<String> input) {
    final var computer = new HashComputer();
    return input.stream().mapToLong(computer::compute).sum();
  }


}
