package fpc.aoc.common;

import lombok.NonNull;
import lombok.Value;

import java.util.List;
import java.util.stream.Stream;

@Value
public class Position {

  int x;

  int y;

  public static @NonNull Position of(int x, int y) {
    return new Position(x, y);
  }

  public @NonNull Position displaced(@NonNull Translation translation) {
    return translate(translation.dx(), translation.dy());
  }

  public @NonNull Position translate(int dx, int dy) {
    return of(x + dx, y + dy);
  }

  public @NonNull Position translateX(int dx) {
    return translate(dx, 0);
  }

  public @NonNull Position translateY(int dy) {
    return translate(0, dy);
  }

  @NonNull
  public Position up() {
    return translateY(-1);
  }

  @NonNull
  public Position down() {
    return translateY(1);
  }

  @NonNull
  public Position down(int numberOfTimes) {
    return translateY(numberOfTimes);
  }

  @NonNull
  public Position left() {
    return translateX(-1);
  }

  @NonNull
  public Position right() {
    return translateX(1);
  }

  @NonNull
  public Position right(int numberOfTimes) {
    return translateX(numberOfTimes);
  }

  @NonNull
  public Orientation orientationOf(@NonNull Position target) {
    if (this.equals(target)) {
      throw new IllegalArgumentException("Same position");
    }
    if (x == target.x) {
      return y < target.y ? Orientation.S : Orientation.N;
    } else if (y == target.y) {
      return x < target.x ? Orientation.E : Orientation.W;
    }
    throw new IllegalArgumentException("Positions not vertically or horizontally aligned " + this + " " + target);
  }

  @NonNull
  public Stream<Position> neighbourStream() {
    return Stream.of(right(), up(), down(), left());
  }

  public @NonNull Position wrap(int width, int height) {
    final int nx = Tools.mod(x, width);
    final int ny = Tools.mod(y, height);
    if (nx == x && ny == y) {
      return this;
    }
    return of(nx, ny);
  }

  public int linearIndex(int lineStride) {
    return x + y * lineStride;
  }

  @Override
  public String toString() {
    return "(x=" + x + ", y=" + y + ")";
  }

  public int manhattanDistanceTo(Position beacon) {
    return Math.abs(this.x - beacon.x) + Math.abs(this.y - beacon.y);
  }

  public static @NonNull Position parseCommaSeparated(@NonNull String value) {
    final var idx = value.indexOf(",");
    return Position.of(Integer.parseInt(value.substring(0, idx)), Integer.parseInt(value.substring(idx + 1)));
  }

  @NonNull
  public List<String> putXYInListOfString() {
    return List.of(String.valueOf(x), String.valueOf(y));
  }


}
