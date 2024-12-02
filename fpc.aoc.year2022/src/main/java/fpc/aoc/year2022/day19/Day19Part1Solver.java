package fpc.aoc.year2022.day19;

import fpc.aoc.api.Solver;

import java.util.stream.Stream;

public class Day19Part1Solver extends Day19Solver {

  public static Solver provider() {
    return new Day19Part1Solver();
  }


  @Override
  public Long doSolve(Stream<BluePrint> input) {
    return input
        .parallel()
        .mapToLong(this::compute)
        .sum();
  }

  private long compute(BluePrint bluePrint) {
    return Factory.findBest(bluePrint, 24).getQualityLevel();
  }

}
