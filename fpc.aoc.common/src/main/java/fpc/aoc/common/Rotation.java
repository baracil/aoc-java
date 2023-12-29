package fpc.aoc.common;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Rotation {
  _000(0),
  _090(1),
  _180(2),
  _270(3),
  ;

  private final int index;


  public @NonNull Rotation compose(@NonNull Rotation other) {
    final int idx = Tools.mod(this.index + other.index, Holder.ROTATIONS.length);
    return Holder.ROTATIONS[idx];
  }

  /**
   * @param x the x of the given point
   * @param y theyx of the given point
   * @return return the x position of the point (x,y) rotated by this around (-1/2,-1/2)
   */
  public int getX(int x, int y) {
    return switch (this) {
      case _000 -> x;
      case _090 -> y;
      case _180 -> -1 - x;
      case _270 -> -1 - y;
    };
  }

  /**
   * @param x the x of the given point
   * @param y theyx of the given point
   * @return return the y position of the point (x,y) rotated by this around (-1/2,-1/2)
   */
  public int getY(int x, int y) {
    return switch (this) {
      case _000 -> y;
      case _090 -> -1 - x;
      case _180 -> -1 - y;
      case _270 -> x;
    };
  }

  private static class Holder {

    private static final Rotation[] ROTATIONS = {_000, _090, _180, _270};
  }
}
