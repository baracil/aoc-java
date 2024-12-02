package fpc.aoc.year2015.day14;

import fpc.aoc.api.Solver;

import java.util.Arrays;
import java.util.stream.Stream;

public class Day14Part2Solver extends Day14Solver {

  public static Solver provider() {
    return new Day14Part2Solver();
  }

  @Override
  protected Object doSolve(Stream<Reindeer> input) {
    final var reindeers = input.toList();
    final var scores = new int[reindeers.size()];
    final var distances = new int[reindeers.size()];
    for (int time = 1; time < 2503; time++) {
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < reindeers.size(); j++) {
        distances[j] = reindeers.get(j).distance(time);
        max = Math.max(max, distances[j]);
      }

      for (int i = 0; i < distances.length; i++) {
        if (max <= distances[i]) {
          scores[i]++;
        }
      }
    }

    return Arrays.stream(scores).max().orElse(0);
  }
}
