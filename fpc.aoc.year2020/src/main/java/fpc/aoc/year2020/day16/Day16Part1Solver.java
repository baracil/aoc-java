package fpc.aoc.year2020.day16;

import fpc.aoc.api.Solver;

public class Day16Part1Solver extends Day16Solver {

  public static Solver provider() {
    return new Day16Part1Solver();
  }

  @Override
  public Long doSolve(Input input) {
    final var mask = Mask.create(input.fields());

    return (long) input.streamNearByTickets()
        .flatMapToInt(Ticket::values)
        .filter(mask::isNotValid)
        .sum();
  }
}
