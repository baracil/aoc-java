package fpc.aoc.year2022.day22;

import fpc.aoc.common.Position;

public interface UnFold {

  Move findNext(Position position, Orientation orientation);

}
