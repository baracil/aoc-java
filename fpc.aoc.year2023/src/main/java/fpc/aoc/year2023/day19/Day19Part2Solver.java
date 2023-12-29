package fpc.aoc.year2023.day19;

import fpc.aoc.api.Solver;
import fpc.aoc.year2023.day19.model.Input;
import fpc.aoc.year2023.day19.model.MultiScrap;
import fpc.aoc.year2023.day19.model.Range;
import lombok.NonNull;

public class Day19Part2Solver extends Day19Solver {

  public static @NonNull Solver provider() {
    return new Day19Part2Solver();
  }


  @Override
  public @NonNull Object doSolve(@NonNull Input input) {
    final var r = new Range(1, 4000);
    final var scraps = input.process(new MultiScrap(r, r, r, r));


    return scraps.stream().mapToLong(MultiScrap::nbScraps).sum();
  }

}
