package fpc.aoc.year2015.day6;

import fpc.aoc.api.Solver;
import fpc.aoc.common.GridHelper;
import fpc.aoc.common.Position;
import lombok.NonNull;

import java.util.List;

public class Day6Part2Solver extends Day6Solver {

  public static @NonNull Solver provider() {
    return new Day6Part2Solver();
  }

  @Override
  public @NonNull Long doSolve(@NonNull List<Command> input) {
    final var helper = GridHelper.create(1000, 1000);

    return helper.allPositionOnGrid().mapToLong(p -> computePower(p, input)).sum();
  }

  private long computePower(Position p, List<Command> input) {
    long power = 0;
    for (Command command : input) {
      if (command.isIn(p.x(),p.y())) {
        switch (command.type()) {
          case ON -> power += 1;
          case OFF -> power = power <= 1 ? 0 : power - 1;
          case TOGGLE -> power += 2;
        }
      }
    }
    return power;
  }
}
