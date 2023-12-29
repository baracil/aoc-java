package fpc.aoc.year2022.day24;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;

public class Blizzards {

  private final int w;
  private final int h;

  private final boolean[][] left;
  private final boolean[][] right;
  private final boolean[][] up;
  private final boolean[][] down;

  public Blizzards(ArrayOfChar input) {
    this.w = input.width() - 2;
    this.h = input.height() - 2;

    left = new boolean[h][w];
    right = new boolean[h][w];
    up = new boolean[h][w];
    down = new boolean[h][w];

    for (int x = 0; x < input.width(); x++) {
      for (int y = 0; y < input.height(); y++) {
        switch (input.get(x, y)) {
          case '<' -> left[y - 1][x - 1] = true;
          case '>' -> right[y - 1][x - 1] = true;
          case 'v' -> down[y - 1][x - 1] = true;
          case '^' -> up[y - 1][x - 1] = true;
        }
      }
    }
  }

  public boolean canMoveTo(Position position, int turn) {
    final var x = position.x() - 1;
    final var y = position.y() - 1;

    if (leftPresent(x, y, turn)) {
      return false;
    }
    if (rightPresent(x, y, turn)) {
      return false;
    }
    if (upPresent(x, y, turn)) {
      return false;
    }
    return !downPresent(x, y, turn);
  }

  private boolean leftPresent(int x, int y, int turn) {
    return left[y][mod(x + turn, w)];
  }

  private boolean rightPresent(int x, int y, int turn) {
    return right[y][mod(x - turn, w)];
  }

  private boolean upPresent(int x, int y, int turn) {
    return up[mod(y + turn, h)][x];
  }

  private boolean downPresent(int x, int y, int turn) {
    return down[mod(y - turn, h)][x];
  }

  private int mod(int value, int modulo) {
    return ((value % modulo) + modulo) % modulo;
  }

  public void dump(int turn) {
    System.out.println();
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        final var mask = getMask(x, y, turn);
        final var c = switch (mask) {
          case 0b0001 -> '<';
          case 0b0010 -> '>';
          case 0b0100 -> '^';
          case 0b1000 -> 'v';
          case 0b0011, 0b0101, 0b1001, 0b0110, 0b1010, 0b1100 -> '2';
          case 0b0111, 0b1011, 0b1101, 0b1110 -> '3';
          case 0b1111 -> '4';
          default -> '.';
        };
        System.out.print(c);
      }
      System.out.println();
    }
  }

  private int getMask(int x, int y, int turn) {
    return (leftPresent(x, y, turn) ? 1 : 0)
        + (rightPresent(x, y, turn) ? 2 : 0)
        + (upPresent(x, y, turn) ? 4 : 0)
        + (downPresent(x, y, turn) ? 8 : 0);
  }
}
