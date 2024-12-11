package fpc.aoc.year2024.day11;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Counter {

  private static final BigInteger _2024 = BigInteger.valueOf(2024);

  private final int nbBlinks;
  private final Map<Key, Long> cache = new ConcurrentHashMap<>();

  public Counter(int nbBlinks) {
    this.nbBlinks = nbBlinks;
  }

  public long count(int[] values) {
    return Arrays.stream(values).mapToLong(v -> count(BigInteger.valueOf(v))).sum();
  }

  public long count(BigInteger value) {
    return compute(value, nbBlinks);
  }

  private long compute(BigInteger value, int depth) {
    if (depth == 0) {
      return 1;
    }

    final var key = new Key(value, depth);
    final var cached = cache.get(key);
    if (cached != null) {
      return cached;
    }

    final long result;
    if (value.equals(BigInteger.ZERO)) {
      result = compute(BigInteger.ONE, depth - 1);
    } else {
      final var s = value.toString();
      final var length = s.length();
      if (length % 2 == 1) {
        result = compute(value.multiply(_2024), depth - 1);
      } else {
        final var b1 = new BigInteger(s.substring(0, length / 2));
        final var b2 = new BigInteger(s.substring(length / 2));
        result = compute(b1, depth - 1) + compute(b2, depth - 1);
      }
    }
    cache.put(key, result);
    return result;
  }

  private record Key(BigInteger value, int depth) {
  }
}
