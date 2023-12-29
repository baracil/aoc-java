package fpc.aoc.year2020.day10.structures;

import java.util.HashMap;
import java.util.Map;

public class TriFibonacci {

  private final Map<Integer, Long> cache = new HashMap<>();

  public TriFibonacci() {
    cache.put(0, 0L);
    cache.put(1, 1L);
    cache.put(2, 1L);
    cache.put(3, 2L);
  }

  public long valueAt(int index) {
    final Long cached = cache.get(index);
    if (cached == null) {
      long result = valueAt(index - 1) + valueAt(index - 2) + valueAt(index - 3);
      cache.put(index, result);
      return result;
    }
    return cached;
  }
}
