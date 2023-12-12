package fpc.aoc.day12;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day12Part1Solver extends Day12Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day12Part1Solver().createProblem();
  }


  @Override
  public @NonNull Long solve(@NonNull Stream<Row> input) {
    return input.mapToLong(ArrangementCounter::count).sum();
  }
}
