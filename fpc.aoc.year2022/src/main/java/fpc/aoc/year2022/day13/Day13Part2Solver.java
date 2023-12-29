package fpc.aoc.year2022.day13;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day13Part2Solver extends Day13Solver {

  public static @NonNull Solver provider() {
    return new Day13Part2Solver();
  }


  @Override
  public @NonNull Integer doSolve(@NonNull List<PairOfItem> input) {
    final var divider1 = ItemParserWithStack.parse("[[2]]");
    final var divider2 = ItemParserWithStack.parse("[[6]]");
    final var sortedItems = Stream.concat(
            input.stream().flatMap(PairOfItem::items),
            Stream.of(divider1, divider2)
        ).sorted()
        .toList();

    return IntStream.range(0, sortedItems.size())
        .filter(i -> sortedItems.get(i) == divider1 || sortedItems.get(i) == divider2)
        .map(i -> i + 1)
        .reduce(1, (a, b) -> a * b);
  }
}
