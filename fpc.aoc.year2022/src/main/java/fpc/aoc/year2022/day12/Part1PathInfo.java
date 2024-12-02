package fpc.aoc.year2022.day12;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;

public class Part1PathInfo implements PathInfo {

  @Override
  public Position startingPosition(ArrayOfChar heights) {
    return heights.findMatching('S').orElseThrow(() -> new AOCException("Could not find starting position"));
  }

  @Override
  public boolean isTargetReached(int height) {
    return height == 'E';
  }

  @Override
  public boolean isReachable(int startHeight, int targetHeight) {
    return targetHeight - startHeight <= 1;
  }
}
