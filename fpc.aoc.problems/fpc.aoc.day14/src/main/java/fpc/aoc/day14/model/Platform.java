package fpc.aoc.day14.model;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.GridHelper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Platform {

  private final int width;
  private final int height;
  private final Type[] types;


  public Platform duplicate() {
    return new Platform(width, height, types.clone());
  }

  public String toString() {
    return Arrays.stream(types).filter(c -> c != Type.LIMIT).map(Type::chr).collect(joining());
  }

  public Platform(ArrayOfChar array) {
    this.width = array.width() + 2;
    this.height = array.height() + 2;
    types = new Type[(width) * (height)];
    Arrays.fill(types, Type.LIMIT);


    final var helper = GridHelper.create(width, height);
    for (int x = 1; x < width - 1; x++) {
      for (int y = 1; y < height - 1; y++) {
        final var c = array.get(x - 1, y - 1);
        types[helper.linearIndexFor(x, y)] = c == '#' ? Type.CUBE : (c == 'O' ? Type.ROUND : Type.EMPTY);
      }
    }
  }

  public int computeNorthWeight() {
    int sum = 0;
    for (int colIdx = 1; colIdx < height - 1; colIdx++) {
      int offset = 1 + width * colIdx;
      for (int rowIdx = 1; rowIdx < width - 1; rowIdx++) {
        final var t = types[offset++];
        if (t == Type.ROUND) {
          sum += height - colIdx - 1;
        }
      }
    }
    return sum;
  }

  public void performOneCycle() {
    tileToNorth();
    tileToWest();
    tileToSouth();
    tileToEast();
  }

  public void tileToWest() {
    for (int rowIdx = 1; rowIdx < height - 1; rowIdx++) {
      final var columnIdx = 1;
      tile(rowIdx, columnIdx, 1);
    }
  }

  public void tileToEast() {
    for (int rowIdx = 1; rowIdx < height - 1; rowIdx++) {
      final var columnIdx = width - 2;
      tile(rowIdx, columnIdx, -1);
    }
  }

  public void tileToNorth() {
    for (int columnIdx = 1; columnIdx < width - 1; columnIdx++) {
      final var rowIdx = 1;
      tile(rowIdx, columnIdx, width);
    }
  }

  public void tileToSouth() {
    for (int columnIdx = 1; columnIdx < width - 1; columnIdx++) {
      final var rowIdx = height - 2;
      tile(rowIdx, columnIdx, -width);
    }
  }


  private void tile(int rowIdx, int columnIdx, int delta) {
    int lastEmpty = -1;
    for (int idx = rowIdx * width + columnIdx; ; idx += delta) {
      final var t = types[idx];
      if (t == Type.ROUND && lastEmpty >= 0) {
        types[lastEmpty] = Type.ROUND;
        types[idx] = Type.EMPTY;
        lastEmpty += delta;
      } else if (t == Type.EMPTY && lastEmpty < 0) {
        lastEmpty = idx;
      } else if (t == Type.CUBE) {
        lastEmpty = -1;
      } else if (t == Type.LIMIT) {
        break;
      }
    }
  }


}
