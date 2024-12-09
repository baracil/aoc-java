package fpc.aoc.common;

import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class Divisor {

  public static void main(String[] args) {
    final var cache = new HashMap<Long, Long>();
    final var result = eulerLawWithCache(6, cache);
    System.out.println(result);
    System.out.println(cache);

  }

  private static final int[] SUM = {0, 1, 3, 4, 7, 6, 12, 8, 15, 13, 18, 12, 28, 14, 24, 24, 31, 18, 39, 20, 42, 32, 36, 24, 60, 31, 42, 40, 56, 30, 72, 32, 63, 48, 54, 48, 91, 38, 60, 56, 90, 42, 96, 44, 84, 78, 72, 48, 124, 57, 93, 72, 98, 54, 120, 72, 120, 80, 90, 60, 168, 62, 96, 104, 127, 84, 144, 68, 126, 96, 144};

  public static long eulerLawWithCache(long n, Map<Long, Long> cache) {
    if (n < SUM.length) {
      return SUM[(int) n];
    }
    final var fromCache = cache.get(n);
    if (fromCache != null) {
      return fromCache;
    }

    long result = 0;

    for (int i = 1; ; i++) {
      boolean iEven = i % 2 == 0;

      final var ref1 = i * (3 * i - 1) / 2;
      final var ref2 = ref1 + i;
      final var k1 = n - ref1;
      final long fk1 = computeFk(n, k1, cache);
      if (fk1 < 0) {
        break;
      }
      result += iEven ? -fk1 : fk1;

      final var k2 = n - ref2;
      final long fk2 = computeFk(n, k2, cache);
      if (fk2 < 0) {
        break;
      }
      result += iEven ? -fk2 : fk2;
    }
    cache.put(n, result);
    return result;
  }

  private static long computeFk(long n, long k, Map<Long, Long> cache) {
    if (k < 0) {
      return -1;
    } else if (k == 0) {
      return n;
    }
    return eulerLawWithCache(k, cache);
  }


  @Getter
  public static class PentagonNumber extends Number {

    private final long n;
    private final boolean negative;
    private final long value;

    public PentagonNumber(long n, boolean negative) {
      var val = n * (3 * n - 1) / 2;
      if (negative) {
        val += n;
      }
      this.n = n;
      this.negative = negative;
      this.value = val;
    }

    @Override
    public int intValue() {
      return Math.toIntExact(value);
    }

    @Override
    public long longValue() {
      return value;
    }

    @Override
    public float floatValue() {
      return value;
    }

    @Override
    public double doubleValue() {
      return value;
    }
  }
}
