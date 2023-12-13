package fpc.aoc.day13;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day13Part1Solver extends Day13Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day13Part1Solver().createProblem();
  }


  @Override
  protected Checker createChecker() {
    return new Part1Checker();
  }
}
