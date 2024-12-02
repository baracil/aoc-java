package fpc.aoc.api;

import java.util.Comparator;

public interface Solver {

  Comparator<Solver> CHRONOLOGICAL = Comparator.comparing(Solver::id);

  SolverId id();

  Object solve(RawInput input);

  default boolean isSkipped() {
    return false;
  }
}
