package fpc.aoc.year2022.day9;

import fpc.aoc.common.Displacement;
import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Knot {

  @Getter
  @NonNull Position position;

  public void displaced(Displacement displacement) {
    this.position = position.displaced(displacement);
  }

  public int x() {
    return position.x();
  }

  public int y() {
    return position.y();
  }

  public void follow(Knot knot) {

    final int dx = position.x() - knot.x();
    final int dy = position.y() - knot.y();


    if (Math.abs(dx) == 2 && Math.abs(dy) == 2) {
      int mx = dx<0?-1:1;
      int my = dy<0?-1:1;
      position = Position.of(knot.x()+mx,knot.y()+my);
    }
    else if (dx == -2) {
      position = Position.of(knot.x() - 1, knot.y());
    } else if (dx == 2) {
      position = Position.of(knot.x() + 1, knot.y());
    }
    else if (dy == -2) {
      position = Position.of(knot.x(), knot.y() - 1);
    } else if (dy == 2) {
      position = Position.of(knot.x(), knot.y() + 1);
    }
  }



}
