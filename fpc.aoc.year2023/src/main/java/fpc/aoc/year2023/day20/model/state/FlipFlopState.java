package fpc.aoc.year2023.day20.model.state;

public enum FlipFlopState {
  ON,
  OFF,
  ;

  public FlipFlopState toggle() {
    return this == ON ? OFF : ON;
  }
}
