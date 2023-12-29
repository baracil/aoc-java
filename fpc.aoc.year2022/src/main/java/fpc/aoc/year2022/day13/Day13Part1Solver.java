package fpc.aoc.year2022.day13;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.List;

public class Day13Part1Solver extends Day13Solver {

  public static @NonNull Solver provider() {
    return new Day13Part1Solver();
  }


  @Override
  public @NonNull Integer doSolve(@NonNull List<PairOfItem> input) {
    return input.stream()
        .filter(PairOfItem::isInCorrectOrder)
        .mapToInt(PairOfItem::index).sum();
  }
}
