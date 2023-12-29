package fpc.aoc.common;

import lombok.NonNull;

public interface PositionFactory {

  @NonNull Position at(int x, int y);
}
