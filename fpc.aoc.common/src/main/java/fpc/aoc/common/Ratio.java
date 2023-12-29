package fpc.aoc.common;


public record Ratio(long numerator, long denominator) {

  public static final Ratio ZERO = new Ratio(0, 1);
  public static final Ratio ONE = new Ratio(1, 1);


  public Ratio invert() {
    if (numerator == 0) {
      throw new AOCException("Cannot divide by 0");
    }
    if (numerator < 0) {
      return new Ratio(-denominator, -numerator);
    }
    return new Ratio(denominator, numerator);
  }

  public Ratio add(Ratio other) {
    if (other.numerator == 0) {
      return this;
    }
    if (this.numerator == 0) {
      return other;
    }
    final var p = gcd(this.denominator, other.denominator);

    final var d1 = this.denominator / p;
    final var d2 = other.denominator / p;

    return new Ratio(this.numerator * d2 + other.numerator * d1, d2 * d1);
  }

  public Ratio subtract(Ratio other) {
    return add(other.negate());
  }

  public Ratio multiply(Ratio other) {
    return multiply(other.numerator, other.denominator);
  }

  public Ratio divide(Ratio other) {
    return multiply(other.invert());
  }

  private Ratio multiply(long numerator, long denominator) {
    final var s1 = Long.compare(this.numerator, 0);
    final var s2 = Long.compare(numerator, 0);
    if (s1 == 0 || s2 == 0) {
      return ZERO;
    }
    final var p1 = gcd(s1 * this.numerator, denominator);
    final var p2 = gcd(s2 * numerator, this.denominator);

    return new Ratio((this.numerator / p1) * (numerator / p2), (this.denominator / p2) * (denominator / p1));
  }


  public Ratio negate() {
    return new Ratio(-numerator, denominator);
  }

  public Ratio multiply(long value) {
    final var s = Long.compare(value, 0);
    if (s == 0) {
      return ZERO;
    }
    final var p = gcd(value * s, denominator);
    return new Ratio(numerator * (value / p), denominator / p);
  }

  public static Ratio from(long value) {
    return new Ratio(value, 1);
  }

  private static long gcd(long a, long b) {
    return Tools.gcd(a, b);
  }

  public boolean isNil() {
    return numerator == 0;
  }

  public long round() {
    return numerator / denominator;
  }
}
