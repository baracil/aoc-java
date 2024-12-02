package fpc.aoc.year2022.day12;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;

public interface PathInfo {

  Position startingPosition(ArrayOfChar heights);

  boolean isTargetReached(int height);

  boolean isReachable(int startHeight, int targetHeight);
}
