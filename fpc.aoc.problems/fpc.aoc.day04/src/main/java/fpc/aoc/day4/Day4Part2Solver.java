package fpc.aoc.day4;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.Arrays;
import java.util.List;

public class Day4Part2Solver extends Day4Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day4Part2Solver().createProblem();
  }


  @Override
  public @NonNull String solve(@NonNull List<Card> input) {
    final long[] counts = new long[input.size()];
    Arrays.fill(counts, 1);

    for (int i = 0; i < input.size(); i++) {
      final var c = input.get(i);
      for (int j = 0, k = i + 1; j < c.nbMatches() && k < counts.length; j++, k++) {
        counts[k] += counts[i] ;
      }
    }


    long sum = 0;
    for (long count : counts) {
      sum += count;
    }

    return String.valueOf(sum);
  }
}
