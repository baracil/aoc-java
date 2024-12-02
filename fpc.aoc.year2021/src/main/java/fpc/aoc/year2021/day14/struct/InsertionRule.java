package fpc.aoc.year2021.day14.struct;

public record InsertionRule(Couple couple, char middle) {

  public static InsertionRule parse(String line) {
    final var tokens = line.split("->");
    return new InsertionRule(new Couple(tokens[0].charAt(0), tokens[0].charAt(1)), tokens[1].charAt(1));
  }
}
