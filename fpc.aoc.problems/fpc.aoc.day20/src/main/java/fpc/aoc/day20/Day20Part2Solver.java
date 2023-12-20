package fpc.aoc.day20;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.Tools;
import fpc.aoc.day20.model.Circuit;
import fpc.aoc.day20.model.state.CircuitState;
import lombok.NonNull;

import java.util.HashSet;

/**
 * Probably only work on my input. See "day20.png" for insight
 */
public class Day20Part2Solver extends Day20Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day20Part2Solver().createProblem();
  }


  @Override
  public @NonNull Long solve(@NonNull Circuit circuit) {
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
