package fpc.aoc.day12;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day12Part2Solver extends Day12Solver {

    //7278707704334 to high
    public static @NonNull AOCProblem<?> provider() {
        return new Day12Part2Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Stream<Row> input) {
        return input
          .map(Row::unfold)
          .mapToLong(this::count)
          .sum();
    }

    private long count(Row row) {
      return ArrangementCounter.count(row);
    }
}
