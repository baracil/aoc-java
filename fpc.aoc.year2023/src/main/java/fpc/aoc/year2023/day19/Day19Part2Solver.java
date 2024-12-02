package fpc.aoc.year2023.day19;

import fpc.aoc.api.Solver;
import fpc.aoc.year2023.day19.model.Input;
import fpc.aoc.year2023.day19.model.MultiScrap;
import fpc.aoc.year2023.day19.model.Range;

public class Day19Part2Solver extends Day19Solver {

  public static Solver provider() {
    return new Day19Part2Solver();
  }


  @Override
  public Object doSolve(Input input) {
    final var r = new Range(1, 4000);
    final var scraps = input.process(new MultiScrap(r, r, r, r));


    return scraps.stream().mapToLong(MultiScrap::nbScraps).sum();
  }

}
