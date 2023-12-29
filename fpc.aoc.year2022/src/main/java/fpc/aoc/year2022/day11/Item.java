package fpc.aoc.year2022.day11;

public record Item(long worryLevel) {

  @Override
  public String toString() {
    return worryLevel+"";
  }
}
