package fpc.aoc.year2022.day19;

import fpc.aoc.api.Solver;

import java.util.stream.Stream;

public class Day19Part2Solver extends Day19Solver {

  public static Solver provider() {
    return new Day19Part2Solver();
  }


  @Override
  public Long doSolve(Stream<BluePrint> input) {
    return input
        .limit(3)
        .parallel()
        .mapToLong(this::compute)
        .reduce(1, (a, b) -> a * b);
  }

  private long compute(BluePrint bluePrint) {
    return Factory.findBest(bluePrint, 32).nbGeode();
  }

}
