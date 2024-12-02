package fpc.aoc.common;

import java.util.HashMap;
import java.util.Map;

public class HashBag<T> implements Bag<T> {

  private final Map<T, Integer> counts = new HashMap<>();

  @Override
  public int quantity(T element) {
    return counts.getOrDefault(element, 0);
  }

  @Override
  public void addOne(T element) {
    counts.merge(element, 1, this::add);
  }

  @Override
  public void removeOne(T element) {
    counts.merge(element, -1, this::add);
  }

  private Integer add(int i1, int i2) {
    final var result = i1 + i2;
    return result == 0 ? null : result;
  }
}
