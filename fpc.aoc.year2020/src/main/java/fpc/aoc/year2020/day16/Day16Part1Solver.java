package fpc.aoc.year2020.day16;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day16Part1Solver extends Day16Solver {

  public static @NonNull Solver provider() {
    return new Day16Part1Solver();
  }

  @Override
  public @NonNull Long doSolve(@NonNull Input input) {
    final var mask = Mask.create(input.fields());

    return (long) input.streamNearByTickets()
        .flatMapToInt(Ticket::values)
        .filter(mask::isNotValid)
        .sum();
  }
}
