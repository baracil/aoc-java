package fpc.aoc.year2023.day14;

import fpc.aoc.api.Solver;
import fpc.aoc.common.AOCException;
import fpc.aoc.year2023.day14.model.Platform;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Day14Part2Solver extends Day14Solver {

  public static @NonNull Solver provider() {
    return new Day14Part2Solver();
  }


  public static final long NB_CYCLES = 1000000000L;

  @Override
  public @NonNull Object doSolve(@NonNull Platform input) {
    final var c = findCycle(input);

    final var total = (NB_CYCLES - c.offset) % c.period + c.offset;

    for (int i = 0; i < total; i++) {
      input.performOneCycle();
    }

    return input.computeNorthWeight();
  }

  private CycleInfo findCycle(@NonNull Platform platform) {
    final var p = platform.duplicate();
    final Map<String, Long> cache = new HashMap<>();

    cache.put(p.toString(), 0L);

    for (long i = 0L; i < NB_CYCLES; i++) {
      p.performOneCycle();
      final var s = p.toString();
      final var existing = cache.get(s);
      if (existing != null) {
        return new CycleInfo(existing, i + 1 - existing);
      }
      cache.put(s, i + 1);
    }
    throw new AOCException("No cycle found");
  }

  public record CycleInfo(long offset, long period) {

  }
}
