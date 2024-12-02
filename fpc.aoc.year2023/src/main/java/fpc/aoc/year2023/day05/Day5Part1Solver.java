package fpc.aoc.year2023.day05;

import fpc.aoc.api.Solver;
import fpc.aoc.year2023.day05.data.Input;

import java.util.Arrays;

public class Day5Part1Solver extends Day5Solver {

  public static Solver provider() {
    return new Day5Part1Solver();
  }

  @Override
  public Object doSolve(Input input) {
    final var min = Arrays
        .stream(input.seeds1())
        .map(input::map)
        .min()
        .orElse(0);

    return String.valueOf(min);
  }

}
