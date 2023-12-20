package fpc.aoc.day20;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.day20.model.Circuit;
import lombok.NonNull;

public class Day20Part1Solver extends Day20Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day20Part1Solver().createProblem();
  }


  @Override
  public @NonNull Long solve(@NonNull Circuit circuit) {
    var state = circuit.initialState();

    long nbLow = 0;
    long nbHigh = 0;

    for (int i = 0; i < 1000; i++) {
      final var result = circuit.execute(state);
      nbLow += result.nbLow();
      nbHigh += result.nbHigh();
      state = result.state();
    }

    return nbHigh*nbLow;
  }
}
