package fpc.aoc.day20;

public enum FlipFlopState {
  ON,
  OFF,
  ;

  public FlipFlopState toggle() {
    return this==ON?OFF:ON;
  }
}
