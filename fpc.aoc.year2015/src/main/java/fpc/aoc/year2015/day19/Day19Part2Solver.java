package fpc.aoc.year2015.day19;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day19Part2Solver extends Day19Solver {

  public static @NonNull Solver provider() {
    return new Day19Part2Solver();
  }

  @Override
  public @NonNull Long doSolve(@NonNull Input input) {
    return Synthesizer.synthesize(input);
  }
}
