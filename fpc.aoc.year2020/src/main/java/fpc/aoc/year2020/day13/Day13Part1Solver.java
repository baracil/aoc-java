package fpc.aoc.year2020.day13;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.math.BigInteger;

public class Day13Part1Solver extends Day13Solver {

  public static @NonNull Solver provider() {
    return new Day13Part1Solver();
  }

  @Override
  public @NonNull BigInteger doSolve(@NonNull Notes input) {
    final NextStop nextStop = input.findNextStop();

    return nextStop.busId().multiply(nextStop.waitingTime());
  }
}
