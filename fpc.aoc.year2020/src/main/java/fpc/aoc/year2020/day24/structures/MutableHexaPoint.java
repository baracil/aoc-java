package fpc.aoc.year2020.day24.structures;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class MutableHexaPoint {

  private int x;
  private int y;

  public HexaPoint toImmutable() {
    return new HexaPoint(x, y);
  }

  public void move(Direction direction) {
    switch (direction) {
      case E -> x = x + 2;
      case NE -> {
        x++;
        y++;
      }
      case NW -> {
        x--;
        y++;
      }
      case W -> x = x - 2;
      case SW -> {
        x--;
        y--;
      }
      case SE -> {
        x++;
        y--;
      }
    }
  }
}
