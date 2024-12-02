package fpc.aoc.year2020.day5;


import fpc.aoc.api.Solver;
import fpc.aoc.common.Tools;
import fpc.aoc.year2020.day5.structures.BoardingPass;

import java.util.stream.Stream;

public class Day5Part2Solver extends Day5Solver<Long> {

  public static Solver provider() {
    return new Day5Part2Solver();
  }

  @Override
  public Long doSolve(Stream<BoardingPass> input) {
    final var statistic = input.mapToInt(BoardingPass::getSeatId)
        .summaryStatistics();
    final var sumFromMinToMax = Tools.sumUpTo(statistic.getMax()) - Tools.sumUpTo(statistic.getMin() - 1);

    return sumFromMinToMax - statistic.getSum();
  }
}
