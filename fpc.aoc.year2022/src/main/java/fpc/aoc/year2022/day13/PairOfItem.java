package fpc.aoc.year2022.day13;

import java.util.stream.Stream;

public record PairOfItem(int index, Item first, Item second) {

  public boolean isInCorrectOrder() {
    return first.compareTo(second) < 0;
  }

  public Stream<Item> items() {
    return Stream.of(first,second);
  }
}
