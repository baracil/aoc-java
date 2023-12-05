package fpc.aoc.day5;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.day5.data.Input;
import fpc.aoc.day5.data.Range;
import lombok.NonNull;

public class Day5Part2Solver extends Day5Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day5Part2Solver().createProblem();
  }


  @Override
  public @NonNull String solve(@NonNull Input input) {
    var ranges = input.map(input.seeds2());

    final var min = ranges.stream().mapToLong(Range::start).min().orElse(0);

    return String.valueOf(min);

  }
}
