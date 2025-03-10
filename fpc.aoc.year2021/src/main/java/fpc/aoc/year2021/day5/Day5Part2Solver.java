package fpc.aoc.year2021.day5;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day5.struct.Vent;

import java.util.stream.Stream;

public class Day5Part2Solver extends Day5Solver {

  public static Solver provider() {
    return new Day5Part2Solver();
  }

  @Override
  public String doSolve(Stream<Vent> input) {
    return doSolve(input, v -> true);
  }
}
