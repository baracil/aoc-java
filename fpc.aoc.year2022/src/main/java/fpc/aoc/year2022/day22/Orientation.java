package fpc.aoc.year2022.day22;

import fpc.aoc.common.Displacement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Orientation {
  RIGHT(Displacement.E, 0),
  DOWN(Displacement.S, 1),
  LEFT(Displacement.W, 2),
  UP(Displacement.N, 3),
  ;
  @Getter
  private final Displacement displacement;
  @Getter
  private final int value;

  public Orientation clockwise() {
    return switch (this) {
      case RIGHT -> DOWN;
      case DOWN -> LEFT;
      case LEFT -> UP;
      case UP -> RIGHT;
    };
  }

  public Orientation antiClockwise() {
    return switch (this) {
      case RIGHT -> UP;
      case DOWN -> RIGHT;
      case LEFT -> DOWN;
      case UP -> LEFT;
    };
  }
}
