package fpc.aoc.year2022.day12;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;
import lombok.NonNull;

public interface PathInfo {

  @NonNull Position startingPosition(@NonNull ArrayOfChar heights);

  boolean isTargetReached(int height);

  boolean isReachable(int startHeight, int targetHeight);
}
