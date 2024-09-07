package fpc.aoc.year2015.day19;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day19Part1Solver extends Day19Solver {

  public static @NonNull Solver provider() {
    return new Day19Part1Solver();
  }

  @Override
  public @NonNull Long doSolve(@NonNull Input input) {
    return Calibrator.calibrate(input);
  }
}
