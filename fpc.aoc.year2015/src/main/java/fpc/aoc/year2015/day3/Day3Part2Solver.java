package fpc.aoc.year2015.day3;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Displacement;
import fpc.aoc.common.Position;
import lombok.NonNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3Part2Solver extends Day3Solver {

  public static @NonNull Solver provider() {
    return new Day3Part2Solver();
  }

  @Override
  public @NonNull Integer doSolve(@NonNull List<Displacement> input) {
    final Set<Position> visited = new HashSet<>();
    var position1 = Position.of(0,0);
    var position2 = Position.of(0,0);
    visited.add(position1);
    visited.add(position2);

    for (int i = 0; i < input.size(); i+=2) {
      position1 = position1.displaced(input.get(i));
      position2 = position2.displaced(input.get(i+1));

      visited.add(position1);
      visited.add(position2);

    }


    return visited.size();

  }

}
