package fpc.aoc.day5.data;

public record Range(long start, long end) {

  public Range shift(long shift) {
    return new Range(start + shift, end + shift);
  }

}
