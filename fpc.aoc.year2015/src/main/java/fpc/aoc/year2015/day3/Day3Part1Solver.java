package fpc.aoc.year2015.day3;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Displacement;
import fpc.aoc.common.Position;
import lombok.NonNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3Part1Solver extends Day3Solver {

  public static @NonNull Solver provider() {
    return new Day3Part1Solver();
  }

  @Override
  public @NonNull Integer doSolve(@NonNull List<Displacement> input) {
    final Set<Position> visited = new HashSet<>();
    var position = Position.of(0, 0);
    visited.add(position);

    for (Displacement displacement : input) {
      position = position.displaced(displacement);
      visited.add(position);
    }

    return visited.size();
  }

}
