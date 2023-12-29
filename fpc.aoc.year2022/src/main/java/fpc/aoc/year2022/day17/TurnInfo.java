package fpc.aoc.year2022.day17;

import lombok.NonNull;
import lombok.Value;

@Value
public class TurnInfo {
  @NonNull ShapeType shapeType;
  @NonNull Snapshot snapshot;
  long turnIndex;
  long height;

  public TurnInfo(@NonNull ShapeType shapeType, @NonNull Snapshot snapshot, long turnIndex, long height) {
    this.shapeType = shapeType;
    this.snapshot = snapshot;
    this.turnIndex = turnIndex;
    this.height = height;
  }

}
