package fpc.aoc.year2022.day12;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;

public class Part2PathInfo implements PathInfo {

  @Override
  public Position startingPosition(ArrayOfChar heights) {
    return heights.findMatching('E').orElseThrow(() -> new AOCException("Could not find starting position"));
  }

  @Override
  public boolean isTargetReached(int height) {
    return height == 'a' || height == 'S';
  }

  @Override
  public boolean isReachable(int startHeight, int targetHeight) {
    return startHeight - targetHeight <= 1;
  }
}
