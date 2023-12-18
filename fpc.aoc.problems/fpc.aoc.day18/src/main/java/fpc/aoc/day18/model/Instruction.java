package fpc.aoc.day18.model;

import fpc.aoc.common.Orientation;
import fpc.aoc.common.Translation;

public record Instruction(Orientation orientation, int length) implements Translation {

  @Override
  public int dx() {
    return orientation.dx()*length;
  }

  @Override
  public int dy() {
    return orientation.dy()*length;
  }
}
