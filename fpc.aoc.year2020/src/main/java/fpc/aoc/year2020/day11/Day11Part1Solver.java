package fpc.aoc.year2020.day11;

import fpc.aoc.api.Solver;
import fpc.aoc.common.GridHelper;
import fpc.aoc.year2020.day11.structures.AdjacentCounter;
import fpc.aoc.year2020.day11.structures.StateEvolutionRule;
import fpc.aoc.year2020.day11.structures.algo.AroundAdjacentCounter;
import fpc.aoc.year2020.day11.structures.algo.WithLeavingThresholdRule;
import lombok.NonNull;

public class Day11Part1Solver extends Day11Solver {

  public static @NonNull Solver provider() {
    return new Day11Part1Solver();
  }

  @Override
  protected @NonNull AdjacentCounter createCounter(@NonNull GridHelper gridHelper) {
    return new AroundAdjacentCounter(gridHelper);
  }

  @Override
  protected @NonNull StateEvolutionRule createEvolutionRule() {
    return new WithLeavingThresholdRule(4);
  }

}
