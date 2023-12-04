package fpc.aoc.day4;

public record Card(String id, int nbMatches) {
  public int score() {
    return nbMatches == 0?0:1<<(nbMatches-1);
  }
}
