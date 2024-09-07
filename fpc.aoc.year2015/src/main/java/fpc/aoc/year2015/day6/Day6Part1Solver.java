package fpc.aoc.year2015.day6;

import fpc.aoc.api.Solver;
import fpc.aoc.common.GridHelper;
import fpc.aoc.common.Position;
import lombok.NonNull;

import java.util.List;

public class Day6Part1Solver extends Day6Solver {

  public static @NonNull Solver provider() {
    return new Day6Part1Solver();
  }

  @Override
  public @NonNull Long doSolve(@NonNull List<Command> input) {
    final var helper = GridHelper.create(1000, 1000);

    final var cmd = input.reversed().toArray(Command[]::new);

    return helper.allPositionOnGrid().filter(p -> isLit(p, cmd)).count();
  }

  private boolean isLit(Position p, Command[] input) {
    boolean toggled = false;
    for (Command command : input) {
      if (command.isIn(p.x(),p.y())) {
        switch (command.type()) {
          case TOGGLE:
            toggled = !toggled;
            break;
          case ON:
            return !toggled;
          case OFF:
            return toggled;
        }
      }
    }
    return toggled;
  }
}
