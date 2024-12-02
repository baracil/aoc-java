package fpc.aoc.year2023.day20;

import fpc.aoc.api.Solver;
import fpc.aoc.year2023.day20.model.Circuit;

public class Day20Part1Solver extends Day20Solver {

  public static Solver provider() {
    return new Day20Part1Solver();
  }


  @Override
  public Object doSolve(Circuit circuit) {
    var state = circuit.initialState();

    long nbLow = 0;
    long nbHigh = 0;

    for (int i = 0; i < 1000; i++) {
      final var result = circuit.execute(state);
      nbLow += result.nbLow();
      nbHigh += result.nbHigh();
      state = result.state();
    }

    return nbHigh * nbLow;
  }
}
