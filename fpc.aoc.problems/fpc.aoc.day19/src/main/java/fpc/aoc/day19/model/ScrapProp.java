package fpc.aoc.day19.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ScrapProp {
  X,
  M,
  A,
  S;

  public int applyAsInt(Scrap value) {
    return switch (this) {
      case X -> value.x();
      case M -> value.m();
      case A -> value.a();
      case S -> value.s();
    };
  }

  public Range getRange(MultiScrap value) {
    return switch (this) {
      case X -> value.x();
      case M -> value.m();
      case A -> value.a();
      case S -> value.s();
    };
  }
}
