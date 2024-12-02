package fpc.aoc.year2022.day17;

import lombok.Value;

@Value
public class TurnInfo {
  ShapeType shapeType;
  Snapshot snapshot;
  long turnIndex;
  long height;

  public TurnInfo(ShapeType shapeType, Snapshot snapshot, long turnIndex, long height) {
    this.shapeType = shapeType;
    this.snapshot = snapshot;
    this.turnIndex = turnIndex;
    this.height = height;
  }

}
