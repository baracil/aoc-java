package fpc.aoc.day16;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.Orientation;
import fpc.aoc.common.Position;
import fpc.aoc.day16.model.BeamComputer;
import lombok.NonNull;

public class Day16Part1Solver extends Day16Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day16Part1Solver().createProblem();
  }


  @Override
  public @NonNull Long solve(@NonNull BeamComputer input) {
    return input.compute(new Beam(Position.of(0, 0), Orientation.E));
  }

}
