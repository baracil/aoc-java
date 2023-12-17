package fpc.aoc.day17;

import fpc.aoc.common.Orientation;
import fpc.aoc.common.Position;

public record Step(Position position, int totalHeatLoss, Orientation orientation, int nb) {
  public int x() {
    return position.x();
  }

  public int y() {
    return position.y();
  }

  public static Step first() {
    return new Step(Position.of(0, 0), 0, Orientation.S, 0);
  }

}
