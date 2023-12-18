package fpc.aoc.common._private;

import fpc.aoc.common.Position;
import fpc.aoc.common.PositionMinMax;

public class PositionMinMaxAgg {
  int minX = Integer.MAX_VALUE;
  int minY = Integer.MAX_VALUE;
  int maxX = Integer.MIN_VALUE;
  int maxY = Integer.MIN_VALUE;

  public void add(Position position) {
    this.maxX = Math.max(this.maxX, position.x());
    this.minX = Math.min(this.minX, position.x());
    this.maxY = Math.max(this.maxY, position.y());
    this.minY = Math.min(this.minY, position.y());
  }

  public PositionMinMaxAgg combine(PositionMinMaxAgg other) {
    this.maxX = Math.max(this.maxX, other.maxX);
    this.minX = Math.min(this.minX, other.minX);
    this.maxY = Math.max(this.maxY, other.maxY);
    this.minY = Math.min(this.minY, other.minY);
    return this;
  }

  public PositionMinMax build() {
    return new PositionMinMax(minX, maxX, minY, maxY);
  }
}
