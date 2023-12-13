package fpc.aoc.day13;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day13Part2Solver extends Day13Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day13Part2Solver().createProblem();
  }

  @Override
  protected Checker createChecker() {
    return new Part2Checker();
  }
}
