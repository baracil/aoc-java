package fpc.aoc.year2024.day07;

import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.util.function.BiFunction;

@RequiredArgsConstructor
public enum Operator {
  ADDITION(BigInteger::add),
  MULTIPLICATION(BigInteger::multiply),
  CONCATENATION((a, b) -> new BigInteger(a.toString() + b.toString())),
  ;

  private final BiFunction<BigInteger, BigInteger, BigInteger> operation;

  public BigInteger apply(BigInteger left, BigInteger right) {
    return operation.apply(left, right);
  }

}
