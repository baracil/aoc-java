package fpc.aoc.year2021.day3;


import lombok.NonNull;

public record PowerConsumption(int gammaRate, int epsilonRate) {

  public @NonNull String getRateProduct() {
    return String.valueOf(gammaRate * epsilonRate);
  }

  public static @NonNull PowerConsumption fromDiagnostic(@NonNull DiagnosticReport diagnosticReport) {
    final var gamma = diagnosticReport.bitMaskStream()
        .filter(m -> diagnosticReport.computeBitBalance(m) == BitBalance.MORE_ONES)
        .sum();
    final int epsilon = diagnosticReport.flipBits(gamma);
    return new PowerConsumption(gamma, epsilon);

  }
}
