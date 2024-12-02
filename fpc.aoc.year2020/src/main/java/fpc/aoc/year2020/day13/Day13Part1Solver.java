package fpc.aoc.year2020.day13;

import fpc.aoc.api.Solver;

import java.math.BigInteger;

public class Day13Part1Solver extends Day13Solver {

  public static Solver provider() {
    return new Day13Part1Solver();
  }

  @Override
  public BigInteger doSolve(Notes input) {
    final NextStop nextStop = input.findNextStop();

    return nextStop.busId().multiply(nextStop.waitingTime());
  }
}
