package fpc.aoc.year2022.day17;

import fpc.aoc.common.Position;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public class Shape {

  private final @NonNull ShapeType shapeType;
  private int x;
  private int y;

  public Shape(@NonNull ShapeType shapeType, @NonNull Position position) {
    this.shapeType = shapeType;
    this.x = position.x();
    this.y = position.y();
  }

  public @NonNull Stream<Position> rockPositions() {
    return shapeType.rocks().stream().map(p -> p.translate(x, y));
  }

  public void moveLeft(@NonNull Chamber chamber) {
    if (canGoto(chamber, -1, 0)) {
      this.x -= 1;
    }
  }

  public void moveRight(@NonNull Chamber chamber) {
    if (canGoto(chamber, 1, 0)) {
      this.x += 1;
    }
  }

  public boolean moveDown(@NonNull Chamber chamber) {
    if (canGoto(chamber, 0, -1)) {
      this.y -= 1;
      return false;
    }
    return true;
  }

  private boolean canGoto(@NonNull Chamber chamber, int dx, int dy) {
    return shapeType.rocks()
        .stream()
        .allMatch(p -> chamber.isEmpty(p.x() + this.x + dx, p.y() + this.y + dy));
  }


  @AllArgsConstructor
  public static class Pos {
    int x;
    int y;
  }
}
