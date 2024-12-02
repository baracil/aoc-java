package fpc.aoc.common;

import java.util.stream.Stream;

public interface NeighbourProvider<P> {

  /**
   * @return the neighbours
   */
  Stream<P> neighbours();
}
