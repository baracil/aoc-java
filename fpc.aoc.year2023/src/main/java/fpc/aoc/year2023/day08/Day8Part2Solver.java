package fpc.aoc.year2023.day08;

import fpc.aoc.api.Solver;

import java.math.BigInteger;
import java.util.function.Predicate;

public class Day8Part2Solver extends Day8Solver {

  public static Solver provider() {
    return new Day8Part2Solver();
  }

  @Override
  public Object doSolve(Input input) {
    final Predicate<String> endsWithA = n -> n.charAt(2) == 'A';
    final Predicate<String> endsWithZ = n -> n.charAt(2) == 'Z';

    return input.nodes()
        .filter(endsWithA)
        .mapToLong(p -> input.countSteps(p, endsWithZ))
        .mapToObj(BigInteger::valueOf)
        .reduce(this::lcm)
        .orElse(BigInteger.ZERO)
        .toString();
  }

  private BigInteger lcm(BigInteger b1, BigInteger b2) {
    return b1.multiply(b2).divide(b1.gcd(b2));
  }
}
