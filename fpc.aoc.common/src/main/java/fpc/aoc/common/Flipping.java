package fpc.aoc.common;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Flipping {
  NONE,
  HORIZONTAL, //Flip around a horizontal axis (y inverted)
  VERTICAL,  //Flip around a vertical axis (x inverted)
  ;

  public Flipping rotate90() {
    return switch (this) {
      case NONE -> NONE;
      case HORIZONTAL -> VERTICAL;
      case VERTICAL -> HORIZONTAL;
    };
  }
}
