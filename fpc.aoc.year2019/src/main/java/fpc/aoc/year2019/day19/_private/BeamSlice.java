package fpc.aoc.year2019.day19._private;

import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Bastien Aracil
 **/
@Getter
@RequiredArgsConstructor
public class BeamSlice {

  @NonNull
  private final Position start;

  private final int length;

  public int lengthBelow(int maximalX) {
    return Math.min(start.x() + length, maximalX) - start.x();
  }

  public boolean contain(int xStart, int length) {
    return start.x() <= xStart && xStart + length <= start.x() + this.length;
  }
}
