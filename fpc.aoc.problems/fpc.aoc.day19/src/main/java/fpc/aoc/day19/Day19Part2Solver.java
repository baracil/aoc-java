package fpc.aoc.day19;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.day19.model.Input;
import fpc.aoc.day19.model.MultiScrap;
import fpc.aoc.day19.model.Range;
import lombok.NonNull;

public class Day19Part2Solver extends Day19Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day19Part2Solver().createProblem();
  }


  @Override
  public @NonNull Long solve(@NonNull Input input) {
    final var r = new Range(1, 4000);
    final var scraps = input.process(new MultiScrap(r, r, r, r));


    return scraps.stream().mapToLong(MultiScrap::nbScraps).sum();
  }

}
