package fpc.aoc.api;

import lombok.NonNull;

import java.util.Comparator;

public interface Solver {

  Comparator<Solver> CHRONOLOGICAL = Comparator.comparing(Solver::id);

  @NonNull SolverId id();

  @NonNull Object solve(@NonNull RawInput input);

  default boolean isSkipped() {
    return false;
  }
}
