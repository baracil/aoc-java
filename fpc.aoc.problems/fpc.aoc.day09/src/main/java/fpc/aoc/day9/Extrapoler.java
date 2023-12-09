package fpc.aoc.day9;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Extrapoler {

  private final Computer computer;
  private final int size;
  private final long[][] buffer;


  public long compute() {
    final var level = computeLevels();
    return computeExtrapolatedValuePart(level);
  }


  private int computeLevels() {
    int level = 1;
    while (!computeLevel(level)) {
      level++;
    }
    return level;
  }

  private long computeExtrapolatedValuePart(int level) {
    long result = 0;
    for (int i = level - 1; i >= 0; i--) {
      final var val = buffer[i][computer.getIndex(i, size)];
      result = computer.accumulate(val, result);
    }
    return result;
  }


  public boolean computeLevel(int level) {
    boolean allZero = true;
    final var prevLevel = level - 1;
    for (int i = 0; i < size - level; i++) {
      final var val = buffer[prevLevel][i + 1] - buffer[prevLevel][i];
      buffer[level][i] = val;
      allZero = allZero && val == 0;
    }
    return allZero;
  }


  private static long computePart(long[] values, Computer computer) {
    final var buffer = new long[values.length][values.length];
    System.arraycopy(values, 0, buffer[0], 0, values.length);

    return new Extrapoler(computer, values.length, buffer).compute();
  }

  public static long computePart1(long[] values) {
    return computePart(values, Computer.PART1);
  }

  public static long computePart2(long[] values) {
    return computePart(values, Computer.PART2);
  }

  private interface Computer {

    int getIndex(int i, int size);

    long accumulate(long delta, long acc);

    Computer PART1 = new Computer() {
      @Override
      public int getIndex(int i, int size) {
        return size - i - 1;
      }

      @Override
      public long accumulate(long delta, long acc) {
        return delta + acc;
      }
    };

    Computer PART2 = new Computer() {
      @Override
      public int getIndex(int i, int size) {
        return 0;
      }

      @Override
      public long accumulate(long delta, long acc) {
        return delta - acc;
      }
    };
  }
}
