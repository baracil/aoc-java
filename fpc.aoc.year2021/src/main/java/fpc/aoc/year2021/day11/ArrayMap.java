package fpc.aoc.year2021.day11;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayMap implements Map {

  public static final int SENTINEL = -1;

  private final int[] levels;
  private final int nbCols;
  private final int nbOctopuses;

  private final Deque<Integer> toFlash;
  private final boolean[] flashed;

  private int nbFlashes = 0;

  public ArrayMap(int[] levels, int nbRows, int nbCols) {
    this.levels = levels;
    this.nbCols = nbCols;
    this.toFlash = new ArrayDeque<>(levels.length);
    this.flashed = new boolean[levels.length];
    this.nbOctopuses = (nbCols - 2) * (nbRows - 2);

  }

  @Override
  public boolean executeOneStep() {
    toFlash.clear();
    Arrays.fill(flashed, false);

    increaseLevels();

    int nbFlashes = 0;
    while (!toFlash.isEmpty()) {
      final var idxToFlash = toFlash.removeFirst();
      if (this.performFlash(idxToFlash)) {
        nbFlashes++;
      }
    }
    this.nbFlashes += nbFlashes;
    return nbFlashes == nbOctopuses;
  }

  @Override
  public int numberOfFlashes() {
    return nbFlashes;
  }

  private boolean performFlash(int idxToFlash) {
    if (flashed[idxToFlash]) {
      return false;
    }
    flashed[idxToFlash] = true;
    levels[idxToFlash] = 0;

    neighbourOffsets().map(o -> o + idxToFlash)
        .filter(i -> levels[i] != SENTINEL)
        .filter(i -> !flashed[i])
        .forEach(i -> {
          this.levels[i] += 1;
          if (this.levels[i] > 9) {
            this.toFlash.addLast(i);
          }
        });
    return true;
  }

  private IntStream neighbourOffsets() {
    return IntStream.of(-1 - nbCols, -nbCols, -nbCols + 1, -1, 1, -1 + nbCols, +nbCols, +nbCols + 1);
  }


  private void increaseLevels() {
    for (int i = 0; i < levels.length; i++) {
      final var level = levels[i];
      if (level != SENTINEL) {
        levels[i] += 1;
        if (levels[i] == 10) {
          toFlash.addLast(i);
        }
      }
    }
  }


  public static ArrayMap parse(List<String> lines) {
    final var nbRows = lines.size() + 2;
    final var nbCols = lines.getFirst().length() + 2;


    final var levels = new int[nbCols * nbRows];
    Arrays.fill(levels, SENTINEL);

    for (int i = 0, x = nbCols + 1; i < lines.size(); i++, x += nbCols) {
      final var line = lines.get(i);
      for (int j = 0; j < line.length(); j++) {
        levels[x + j] = line.charAt(j) - '0';
      }
    }


    return new ArrayMap(levels, nbRows, nbCols);
  }
}
