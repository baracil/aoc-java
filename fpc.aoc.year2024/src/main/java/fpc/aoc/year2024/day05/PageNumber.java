package fpc.aoc.year2024.day05;

public record PageNumber(int value) {

  public static PageNumber from(String s) {
    return new PageNumber(Integer.parseInt(s));
  }
}
