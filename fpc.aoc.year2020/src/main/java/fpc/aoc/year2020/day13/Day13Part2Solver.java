package fpc.aoc.year2020.day13;

import fpc.aoc.api.Solver;

import java.math.BigInteger;

public class Day13Part2Solver extends Day13Solver {

  public static Solver provider() {
    return new Day13Part2Solver();
  }

  @Override
  public BigInteger doSolve(Notes input) {
    final var buses = input.buses();

    if (buses.size() == 1) {
      return BigInteger.ZERO;
    }

    final Part2Solver solver1 = new Part2FermatSolver();
    final Part2Solver solver2 = new Part2IncrementalSolver();

    final var solution1 = solver1.doSolve(buses);
    final var solution2 = solver2.doSolve(buses);

    assert solution1.equals(solution2);

    return solution1;
  }

}
