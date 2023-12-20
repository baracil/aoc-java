package fpc.aoc.day19.model;

public record Range(int min, int max) {

  public long length() {
    return max - min + 1L;
  }

  public boolean isEmpty() {
    return max < min;
  }


  @Override
  public String toString() {
    return "[%04d, %04d]".formatted(min, max);
  }

  public Split<Range> lower(int value) {
    return new Split<>(new Range(min, value - 1), new Range(value, max));
  }

  public Split<Range> greater(int value) {
    return new Split<>(new Range(value + 1, max), new Range(min, value));
  }

}
