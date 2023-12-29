package fpc.aoc.year2020.day11;

import fpc.aoc.api.Solver;
import fpc.aoc.common.GridHelper;
import fpc.aoc.year2020.day11.structures.AdjacentCounter;
import fpc.aoc.year2020.day11.structures.StateEvolutionRule;
import fpc.aoc.year2020.day11.structures.algo.OptimizedViewableCounter;
import fpc.aoc.year2020.day11.structures.algo.WithLeavingThresholdRule;
import lombok.NonNull;

public class Day11Part2Solver extends Day11Solver {

  public static @NonNull Solver provider() {
    return new Day11Part2Solver();
  }

  @Override
  protected @NonNull AdjacentCounter createCounter(@NonNull GridHelper gridHelper) {
    return new OptimizedViewableCounter(gridHelper);
  }

  @Override
  protected @NonNull StateEvolutionRule createEvolutionRule() {
    return new WithLeavingThresholdRule(5);
  }

}
