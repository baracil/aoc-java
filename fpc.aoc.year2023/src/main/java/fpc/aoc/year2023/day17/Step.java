package fpc.aoc.year2023.day17;

import fpc.aoc.common.Orientation;
import fpc.aoc.common.Position;

public record Step(Position position, int totalHeatLoss, int heuristic, Orientation orientation, int nb) {
  public int x() {
    return position.x();
  }

  public int y() {
    return position.y();
  }


}
