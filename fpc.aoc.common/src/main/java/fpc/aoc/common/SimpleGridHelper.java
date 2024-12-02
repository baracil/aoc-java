package fpc.aoc.common;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SimpleGridHelper implements GridHelper {

  @Getter
  private final int width;
  @Getter
  private final int height;

  private final Position[] positions;

  public SimpleGridHelper(int width, int height) {
    this.width = width;
    this.height = height;
    this.positions = new Position[width * height];
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        positions[x + y * width] = Position.of(x, y);
      }
    }
  }

  private Position nullableAt(int x, int y) {
    if (x >= 0 && x < width && y >= 0 && y < height) {
      return positions[x + y * width];
    }
    return null;
  }

  @Override
  public Stream<Position> allAdjacentPosition(Position center) {
    final int xc = center.x();
    final int yc = center.y();
    return Stream.of(
        nullableAt(xc - 1, yc - 1),
        nullableAt(xc - 1, yc),
        nullableAt(xc - 1, yc + 1),
        nullableAt(xc + 1, yc - 1),
        nullableAt(xc + 1, yc),
        nullableAt(xc + 1, yc + 1),
        nullableAt(xc, yc - 1),
        nullableAt(xc, yc + 1)
    ).filter(Objects::nonNull);
  }

  @Override
  public Stream<Position> allCardinalNeighbours(Position center) {
    final int xc = center.x();
    final int yc = center.y();
    return Stream.of(
        nullableAt(xc - 1, yc),
        nullableAt(xc + 1, yc),
        nullableAt(xc, yc - 1),
        nullableAt(xc, yc + 1)
    ).filter(Objects::nonNull);
  }


  @Override
  public Stream<Position> positionsInDirection(Position center, Displacement displacement) {
    final int dx = displacement.dx();
    final int dy = displacement.dy();
    return IntStream.iterate(1, i -> i + 1)
        .mapToObj(i -> nullableAt(center.x() + dx * i, center.y() + dy * i))
        .takeWhile(Objects::nonNull);
  }

  @Override
  public boolean isOnBorder(Position position) {
    return position.x() == 0 || position.x() == width - 1 || position.y() == 0 || position.y() == height - 1;
  }

  @Override
  public boolean isInside(Position p) {
    final var x = p.x();
    final var y = p.y();
    return x >= 0 && x < width && y >= 0 && y < height;
  }

  public Stream<Position> allPositionOnGrid() {
    return Arrays.stream(positions);
  }

  @Override
  public int linearIndexFor(Position position) {
    return position.linearIndex(width);
  }

  @Override
  public int linearIndexFor(int x, int y) {
    return x + width * y;
  }

  @Override
  public Position positionFor(int linearIndex) {
    return nullableAt(linearIndex % width, linearIndex / width);
  }
}
