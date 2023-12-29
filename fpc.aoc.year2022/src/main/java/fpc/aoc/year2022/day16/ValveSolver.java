package fpc.aoc.year2022.day16;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class ValveSolver {

  private final Valves valves;
  private final int nbValves;

  public ValveSolver(Valves valves) {
    this.valves = valves;
    this.nbValves = valves.getNbValves();
  }

  public long doSolve(int initialValveStates, int maxTime) {
    final Map<String,Integer> cache = new HashMap<>();
    final var start = new State(valves,initialValveStates,maxTime);
    return findBestFrom(start,cache);
  }

  private int findBestFrom(@NonNull State state, Map<String,Integer> cache) {
    final var cached = cache.get(state.path());
    if (cached != null) {
      return cached;
    }

    if (state.allOpened()) {
      final var result = state.totalAtTheEnd();
      cache.put(state.path(), result);
      return result;
    }

    int best = -1;
    for (int i = 0; i < nbValves; i++) {
      if (state.isOpened(i)) {
        continue;
      }
      final var newState = state.withNewValve(i);
      if (newState.timeLeft() < 0) {
        continue;
      }
      final var pro = findBestFrom(newState,cache);
      if (best < pro) {
        best = pro;
      }
    }

    final var result = best < 0 ? state.totalAtTheEnd() : best;

    cache.put(state.path(), result);
    return result;
  }

}
