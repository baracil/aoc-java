package fpc.aoc.year2021.day3;


public record PowerConsumption(int gammaRate, int epsilonRate) {

  public String getRateProduct() {
    return String.valueOf(gammaRate * epsilonRate);
  }

  public static PowerConsumption fromDiagnostic(DiagnosticReport diagnosticReport) {
    final var gamma = diagnosticReport.bitMaskStream()
        .filter(m -> diagnosticReport.computeBitBalance(m) == BitBalance.MORE_ONES)
        .sum();
    final int epsilon = diagnosticReport.flipBits(gamma);
    return new PowerConsumption(gamma, epsilon);

  }
}
