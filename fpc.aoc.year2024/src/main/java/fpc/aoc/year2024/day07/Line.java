package fpc.aoc.year2024.day07;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class Line {
  @Getter
  private final BigInteger result;
  private final BigInteger[] values;

  public long resultAsLong() {
    return result.longValue();
  }

  public boolean canBeTrueWith(List<Operator> allowedOperators) {
    return allowedOperators.stream().anyMatch(op -> compute(1,values[0],op,allowedOperators));
  }

  private boolean compute(int pos, BigInteger value, Operator operator, List<Operator> allowedOperators) {
    if (pos >= values.length) {
      return value.equals(result);
    }

    if (value.compareTo(result) > 0) {
      return false;
    }

    final int nextPos = pos + 1;
    final BigInteger newValue = operator.apply(value, values[pos]);

    return allowedOperators.stream()
        .anyMatch(op -> compute(nextPos, newValue, op, allowedOperators));
  }


  public static Line parse(String line) {
    final var tokens = line.split("[: ]+");
    final var result = new BigInteger(tokens[0]);
    final var values = Arrays.stream(tokens).skip(1).map(BigInteger::new).toArray(BigInteger[]::new);

    return new Line(result, values);
  }
}
