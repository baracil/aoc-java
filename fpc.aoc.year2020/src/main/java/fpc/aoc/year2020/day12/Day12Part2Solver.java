package fpc.aoc.year2020.day12;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Orientation;
import fpc.aoc.year2020.day12.structures.*;
import lombok.NonNull;

import java.util.List;

public class Day12Part2Solver extends Day12Solver {

  public static @NonNull Solver provider() {
    return new Day12Part2Solver();
  }

  @Override
  public @NonNull Integer doSolve(@NonNull List<Movement> movements) {
    final Ferry ferry = new Ferry(Orientation.E, 0, 0);
    final Waypoint waypoint = new Waypoint(10, 1);

    final Executor executor = new Part2Executor(ferry, waypoint);
    movements.forEach(executor::execute);

    return ferry.manhattanDistance();
  }
}
