package fpc.aoc.year2022.day25;

import fpc.aoc.api.Solver;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Day25Part1Solver extends Day25Solver {

  public static Solver provider() {
    return new Day25Part1Solver();
  }

  @Override
  public String doSolve(Stream<BigInteger> input) {
    final var sum = input.reduce(BigInteger.ZERO, BigInteger::add);
    return Snafu.toSnafu(sum);
  }
}
