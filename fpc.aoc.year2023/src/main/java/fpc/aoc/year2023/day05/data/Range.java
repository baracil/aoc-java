package fpc.aoc.year2023.day05.data;

public record Range(long start, long end) {

  public Range shift(long shift) {
    return new Range(start + shift, end + shift);
  }

}
