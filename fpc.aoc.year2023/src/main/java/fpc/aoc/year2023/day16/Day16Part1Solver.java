package fpc.aoc.year2023.day16;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Orientation;
import fpc.aoc.common.Position;
import fpc.aoc.year2023.day16.model.BeamComputer;

public class Day16Part1Solver extends Day16Solver {

  public static Solver provider() {
    return new Day16Part1Solver();
  }


  @Override
  public Object doSolve(BeamComputer input) {
    return input.compute(new Beam(Position.of(0, 0), Orientation.E));
  }

}
