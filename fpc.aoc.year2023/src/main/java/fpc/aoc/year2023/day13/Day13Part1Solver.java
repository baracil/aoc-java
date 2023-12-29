package fpc.aoc.year2023.day13;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day13Part1Solver extends Day13Solver {

  public static @NonNull Solver provider() {
    return new Day13Part1Solver();
  }


  @Override
  protected Checker createChecker() {
    return new Part1Checker();
  }
}
