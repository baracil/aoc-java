package fpc.aoc.year2020.day24;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day24.structures.Path;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day24Part1Solver extends Day24Solver {

  public static @NonNull Solver provider() {
    return new Day24Part1Solver();
  }

  @Override
  public @NonNull Integer doSolve(@NonNull Stream<Path> input) {
    return initialBlackTiles(input).size();
  }
}
