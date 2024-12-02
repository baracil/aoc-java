package fpc.aoc.year2021.day3;

import java.util.function.BiFunction;

public record LifeSupport(int oxygenGeneratorRating, int co2ScrubberRating) {

  public String getRatingProduct() {
    return String.valueOf(oxygenGeneratorRating * co2ScrubberRating);
  }

  public static LifeSupport from(DiagnosticReport diagnosticReport) {
    final int oxygen = computeRating(diagnosticReport, (b, mask) -> (b == BitBalance.MORE_ZEROES) ? 0 : mask);
    final int co2 = computeRating(diagnosticReport, (b, mask) -> (b == BitBalance.MORE_ZEROES) ? mask : 0);
    return new LifeSupport(oxygen, co2);
  }

  private static int computeRating(DiagnosticReport diagnosticReport,
                                   BiFunction<? super BitBalance, ? super Integer, ? extends Integer> criteria) {
    final var masks = diagnosticReport.bitMaskStream().toArray();
    var sieveValue = 0;
    var sieveMask = 0;
    for (final int mask : masks) {
      final var sieveResult = diagnosticReport.computeSieveBitBalance(sieveValue, sieveMask, mask);

      if (sieveResult instanceof SieveResult.SingleValue singleValue) {
        return singleValue.value();
      } else if (sieveResult instanceof SieveResult.Balance balance) {
        final int value = criteria.apply(balance.bitBalance(), mask);
        sieveMask |= mask;
        sieveValue |= value;
      }
    }
    return sieveValue;
  }
}
