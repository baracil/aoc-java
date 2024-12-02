package fpc.aoc.year2020.day9;

import fpc.aoc.api.Solver;
import fpc.aoc.common.AOCException;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Day9Part1Solver extends Day9Solver {

  public static Solver provider() {
    return new Day9Part1Solver(25);
  }

  private final int preambleSize;

  @Override
  public Long doSolve(long[] input) {
    return IntStream.range(preambleSize, input.length)
        .filter(i -> !isSumOfPreviousLongs(input, i))
        .mapToLong(i -> input[i])
        .findFirst()
        .orElseThrow(() -> new AOCException("You are too stupid to solve this"));
  }

  private boolean isSumOfPreviousLongs(long[] input, int index) {
    final Set<Long> seen = new HashSet<>();
    final long target = input[index];
    for (int i = index - preambleSize; i < index; i++) {
      long current = input[i];
      long complement = target - current;
      seen.add(current);
      if (complement <= 0 || complement == current) {
        continue;
      }
      if (seen.contains(complement)) {
        return true;
      }
    }
    return false;
  }
}
