package fpc.aoc.year2022.day25;


import fpc.aoc.common.AOCException;

import java.math.BigInteger;

public class Snafu {

  private static final char[] CHARS = {'=','-','0','1','2'};

  public static String toSnafu(BigInteger value) {
    var f = TWO;
    while(f.compareTo(value)<0) {
      f = f.multiply(FIVE).add(TWO);
    }
    f = f.add(value);

    final String reversed;
    {
      final var sb = new StringBuilder();
      while (f.compareTo(ZERO)>0) {
        sb.append(CHARS[f.mod(FIVE).intValue()]);
        f = f.divide(FIVE);
      }
      reversed = sb.toString();
    }

    final String right;
    {
      final var sb = new StringBuilder();
      for (int i = 0; i < reversed.length(); i++) {
        sb.append(reversed.charAt(reversed.length()-1-i));
      }
      right = sb.toString();
    }

    return right;
  }

  private static final BigInteger TWO = BigInteger.TWO;
  private static final BigInteger ONE = BigInteger.ONE;
  private static final BigInteger ZERO = BigInteger.ZERO;
  private static final BigInteger FIVE = BigInteger.valueOf(5);
  private static final BigInteger MINUS_ONE = BigInteger.valueOf(-1);
  private static final BigInteger MINUS_TWO = BigInteger.valueOf(-2);

  public static BigInteger toValue(String line) {
    BigInteger value = BigInteger.ZERO;
    BigInteger factor = BigInteger.ONE;
    final var length = line.length();
    for (int i = 0; i < length; i++) {
      final var chr = line.charAt(length-i-1);
      final var digit = switch (chr) {
        case '2' -> TWO;
        case '1' -> ONE;
        case '0' -> ZERO;
        case '-' -> MINUS_ONE;
        case '=' -> MINUS_TWO;
        default -> throw new AOCException("Unknown digit '"+chr+"'");
      };
      value = value.add(factor.multiply(digit));
      factor = factor.multiply(FIVE);
    }
    return value;
  }
}
