package fpc.aoc.common;

import lombok.NonNull;

import java.util.stream.Stream;

public interface NeighbourProvider<P> {

  /**
   * @return the neighbours
   */
  @NonNull Stream<P> neighbours();
}
