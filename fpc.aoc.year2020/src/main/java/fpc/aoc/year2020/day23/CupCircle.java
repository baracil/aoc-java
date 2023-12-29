package fpc.aoc.year2020.day23;

import lombok.NonNull;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class CupCircle {

  private final int[] nextByLabels;

  private int current;

  private final int size;

  public CupCircle(String initialValues) {
    this(initialValues, initialValues.length());
  }

  public CupCircle(String initialValues, int size) {
    this(initialValues.chars().map(i -> i - '1').toArray(), size);
  }

  public CupCircle(int[] initialValues, int size) {
    this.size = size;
    this.nextByLabels = new int[size];

    for (int i = 0; i < size - 1; i++) {
      this.nextByLabels[i] = i + 1;
    }

    for (int i = 0; i < initialValues.length - 1; i++) {
      nextByLabels[initialValues[i]] = initialValues[i + 1];
    }
    if (size > initialValues.length) {
      nextByLabels[initialValues[initialValues.length - 1]] = initialValues.length;
      nextByLabels[size - 1] = initialValues[0];
    } else {
      nextByLabels[initialValues[initialValues.length - 1]] = initialValues[0];
    }
    this.current = initialValues[0];
  }

  public @NonNull String part1Result() {
    final StringBuilder sb = new StringBuilder();
    int n = 0;
    do {
      n = nextByLabels[n];
      if (n == 0) {
        return sb.toString();
      }
      sb.append(n + 1);
    } while (true);
  }

  public @NonNull String part2Result() {
    final var b1 = new BigDecimal(nextByLabels[0] + 1);
    final var b2 = new BigDecimal(nextByLabels[nextByLabels[0]] + 1);
    return b1.multiply(b2).toString();
  }

  public void performMoves(int nbMoves) {
    for (int i = 0; i < nbMoves; i++) {
      performOneMove();
    }
  }

  public void performOneMove() {
    int val = current;
    final var n1 = nextByLabels[current];
    final var n2 = nextByLabels[n1];
    final var n3 = nextByLabels[n2];
    nextByLabels[current] = nextByLabels[n3];
    current = nextByLabels[n3];

    int insertLabel = IntStream.of(-1, -2, -3, -4)
        .map(o -> ((o + val + size) % size))
        .filter(i -> n1 != i && n2 != i && n3 != i)
        .findFirst()
        .getAsInt();


    final int insertNext = nextByLabels[insertLabel];
    nextByLabels[insertLabel] = n1;
    nextByLabels[n3] = insertNext;
  }

}
