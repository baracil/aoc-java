package fpc.aoc.year2015.day14;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day14Part1Solver extends Day14Solver {

  public static @NonNull Solver provider() {
    return new Day14Part1Solver();
  }


  @Override
  protected @NonNull Object doSolve(@NonNull Stream<Reindeer> input) {
    return input.mapToInt(r -> r.distance(2503)).max().orElse(0);
  }
}
