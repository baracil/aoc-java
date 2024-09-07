package fpc.aoc.year2015.day13;

public record Link(String target, int happiness, String neighbour) {

  public static Link parse(String line) {
    final var token = line.split(" ");
    final var target = token[0];
    final var neighbour = token[10];
    final var value = Integer.parseInt(token[3]);
    final var gain = "gain".equals(token[2]);
    return new Link(target,gain?value:-value,neighbour.substring(0,neighbour.length()-1));
  }
}
