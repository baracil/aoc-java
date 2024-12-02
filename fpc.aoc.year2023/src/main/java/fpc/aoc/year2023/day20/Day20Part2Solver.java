package fpc.aoc.year2023.day20;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Tools;
import fpc.aoc.year2023.day20.model.Circuit;
import fpc.aoc.year2023.day20.model.state.CircuitState;

import java.util.HashSet;

/**
 * Probably only work on my input. See "day20.png" for insight
 */
public class Day20Part2Solver extends Day20Solver {

  public static Solver provider() {
    return new Day20Part2Solver();
  }


  @Override
  public Object doSolve(Circuit circuit) {
    final var split = circuit.split();

    return split.stream()
        .mapToLong(this::findPeriod)
        .reduce(1L, Tools::lcm);
  }


  private long findPeriod(Circuit circuit) {
    final var seen = new HashSet<CircuitState>();
    var current = circuit.initialState();
    int i = 0;
    do {
      if (seen.contains(current)) {
        return i;
      }
      seen.add(current);
      i++;
      final var result = circuit.execute(current);
      current = result.state();
    } while (true);
  }

}
