package fpc.aoc.year2020.day14.structures;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

@RequiredArgsConstructor
public class FloatingGenerator {
  public static final int MASK_SIZE = 36;

  public static @NonNull LongStream generate(long floatingMask) {
    final var bits = LongStream.range(0, MASK_SIZE)
        .map(i -> 1L << i)
        .filter(m -> (floatingMask & m) != 0)
        .toArray();
    return new FloatingGenerator(bits).generate();
  }

  private final long[] bits;

  private @NonNull LongStream generate() {
    int n = 1 << bits.length;
    return IntStream.range(0, n)
        .mapToLong(this::getMask);
  }

  private long getMask(int n) {
    long result = 0;
    for (int i = 0; i < bits.length; i++) {
      if ((n & 1) != 0) {
        result |= bits[i];
      }
      n = n >> 1;
    }
    return result;
  }

}
