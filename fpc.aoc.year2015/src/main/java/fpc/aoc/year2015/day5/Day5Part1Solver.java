package fpc.aoc.year2015.day5;

import fpc.aoc.api.Solver;

import java.util.stream.Stream;

public class Day5Part1Solver extends Day5Solver {

  public static Solver provider() {
    return new Day5Part1Solver();
  }


  @Override
  public Long doSolve(Stream<String> input) {
    return input.filter(new NicePredicate1()).count();
  }

}
