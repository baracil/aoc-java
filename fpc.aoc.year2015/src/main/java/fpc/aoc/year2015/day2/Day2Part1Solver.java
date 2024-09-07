package fpc.aoc.year2015.day2;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day2Part1Solver extends Day2Solver {

  public static @NonNull Solver provider() {
    return new Day2Part1Solver();
  }


  @Override
  public @NonNull Integer doSolve(@NonNull Stream<Present> presents) {
    return presents.mapToInt(Present::paperArea).sum();
  }
}
