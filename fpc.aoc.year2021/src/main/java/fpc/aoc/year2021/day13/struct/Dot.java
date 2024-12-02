package fpc.aoc.year2021.day13.struct;

public record Dot(int x, int y) {

  public static Dot with(int x, int y) {
    return new Dot(x, y);
  }

  public static Dot parse(String line) {
    final var tokens = line.split(",");
    return Dot.with(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
  }
}
