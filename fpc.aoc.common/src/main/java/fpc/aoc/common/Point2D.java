package fpc.aoc.common;

import lombok.NonNull;

import java.util.stream.Stream;

public record Point2D(int x, int y) implements NeighbourProvider<Point2D> {

  public Position toPosition() {
    return new Position(x,y);
  }

  @Override
  public @NonNull Stream<Point2D> neighbours() {
    return Stream.of(
      new Point2D(x - 1, y - 1),
      new Point2D(x, y - 1),
      new Point2D(x + 1, y - 1),

      new Point2D(x - 1, y),
      new Point2D(x + 1, y),

      new Point2D(x - 1, y + 1),
      new Point2D(x, y + 1),
      new Point2D(x + 1, y + 1)
    );
  }
}
