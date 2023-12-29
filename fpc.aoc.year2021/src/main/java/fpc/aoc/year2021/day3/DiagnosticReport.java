package fpc.aoc.year2021.day3;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class DiagnosticReport {

  private final int size;
  private final int[] values;

  public static @NonNull DiagnosticReport fromLines(@NonNull List<String> lines) {
    if (lines.isEmpty()) {
      return new DiagnosticReport(0, new int[0]);
    }
    final int size = lines.get(0).length();
    final int[] values = lines.stream().mapToInt(s -> Integer.parseInt(s, 2)).toArray();
    return new DiagnosticReport(size, values);
  }


  /**
   * @return the bit mask that can be used for masking values. They
   * are streamed from the most significant bit to the least one
   */
  public IntStream bitMaskStream() {
    return IntStream.range(0, size).map(i -> size - 1 - i).map(i -> 1 << i);
  }

  public int flipBits(int value) {
    return ((1 << size) - 1) ^ value;
  }

  public @NonNull BitBalance computeBitBalance(int mask) {
    final int balanceCount = Arrays.stream(values)
        .map(v -> (v & mask) == 0 ? -1 : 1)
        .sum();
    return BitBalance.fromBalanceCount(balanceCount);
  }

  public @NonNull SieveResult computeSieveBitBalance(int sieveValue, int sieveMask, int bitMask) {
    return Arrays.stream(values).boxed().collect(SieveResult.collector(sieveValue, sieveMask, bitMask));
  }
}
