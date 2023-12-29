package fpc.aoc.year2023.day10;

import fpc.aoc.api.Solver;
import fpc.aoc.common.AOCException;
import fpc.aoc.common.GenericArray;
import lombok.NonNull;

public class Day10Part2Solver extends Day10Solver {

  public static @NonNull Solver provider() {
    return new Day10Part2Solver();
  }


  @Override
  public @NonNull Object doSolve(@NonNull Map input) {
    final var cleaned = input.cleaned();
    final var width = cleaned.width();
    final var height = cleaned.height();
    int count = 0;
    for (int x = 0; x < width; x++) {
      count += countDiagonal(cleaned, x, 0);
    }
    for (int y = 1; y < height; y++) {
      count += countDiagonal(cleaned, 0, y);
    }

    return count;
  }

  private int countDiagonal(GenericArray<Tile> array, int xs, int ys) {
    int count = 0;
    int x = xs;
    int y = ys;
    boolean cross = false;
    while (x < array.width() && y < array.height()) {
      final var tile = array.get(x, y);
      switch (tile) {
        case PIPE_H, PIPE_V, CORNER_F, CORNER_J -> cross = !cross;
        case FLOOR -> count += (cross ? 1 : 0);
        case START -> throw new AOCException("Not cleaned");
      }
      x += 1;
      y += 1;
    }
    return count;
  }
}
