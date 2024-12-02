package fpc.aoc.year2022.day1;

import fpc.aoc.api.Solver;
import fpc.aoc.common.AOCException;

import java.util.stream.LongStream;

public class Day1Part1Solver extends Day1Solver {

  public static Solver provider() {
    return new Day1Part1Solver();
  }

  @Override
  public Long doSolve(LongStream input) {
    return input.max().orElseThrow(() -> new AOCException("Cannot solve"));
  }

}
