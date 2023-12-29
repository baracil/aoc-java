package fpc.aoc.year2022.day3;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Compartment {

  private final boolean[] items;

  public IntStream items() {
    return IntStream.range(0, items.length).filter(i -> items[i]);
  }

  public boolean contains(int item) {
    return items[item];
  }

  public static @NonNull Compartment parse(@NonNull String line) {
    final var items = new boolean[52];
    Arrays.fill(items, false);
    line.chars().map(Compartment::toItem).forEach(i -> items[i] = true);
    return new Compartment(items);
  }

  public static int toItem(int c) {
    if (c <= 'Z') {
      return (c - 'A') + 26;
    }
    return c - 'a';
  }

}
