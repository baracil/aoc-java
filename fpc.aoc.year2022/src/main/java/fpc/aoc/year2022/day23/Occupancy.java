package fpc.aoc.year2022.day23;

import fpc.aoc.common.Position;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class Occupancy {

  private final int mask;

  public boolean isFree(Direction direction) {
    return (mask&direction.mask()) == 0;
  }


  public static Occupancy compute(Position position, Set<Position> occupiedPositions) {
    int mask = 0;
    for (final Move move : MOVES) {
      if (occupiedPositions.contains(position.displaced(move.displacement()))) {
        mask |= move.mask();
      }
    }
    return new Occupancy(mask);
  }

  private static final Move[] MOVES = {
      Move.NW,
      Move.N,
      Move.NE,
      Move.E,
      Move.SE,
      Move.S,
      Move.SW,
      Move.W,
  };


  public boolean isIsolate() {
    return mask == 0;
  }

  @Override
  public String toString() {
    final var v = ("000000000"+Integer.toString(mask,2));
    return v.substring(v.length()-8);
  }
}
