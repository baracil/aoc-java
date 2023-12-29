package fpc.aoc.year2023.day04;

public record Card(String id, int nbMatches) {
  public int score() {
    return nbMatches == 0 ? 0 : 1 << (nbMatches - 1);
  }
}
