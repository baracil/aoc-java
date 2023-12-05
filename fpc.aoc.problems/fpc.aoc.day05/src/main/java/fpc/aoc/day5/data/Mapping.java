package fpc.aoc.day5.data;

public record Mapping(long start, long end, long destination) {

  public boolean isInside(long value) {
    return value >= start && value < end;
  }

  public static Mapping with(long destination, long source, long length) {
    return new Mapping(source, source + length, destination);
  }

  public long shift() {
    return destination - start;
  }

}
