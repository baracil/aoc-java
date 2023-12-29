package fpc.aoc.year2022.day23;

import fpc.aoc.common.Displacement;
import lombok.Getter;

import java.util.Arrays;

public enum Direction {
  NORTH(Displacement.N,Move.NW,Move.N,Move.NE),
  SOUTH(Displacement.S,Move.SW,Move.S,Move.SE),
  WEST(Displacement.W,Move.NW,Move.W,Move.SW),
  EAST(Displacement.E,Move.NE,Move.E,Move.SE);

  @Getter
  private final int mask;
  @Getter
  private final Displacement displacement;

  Direction(Displacement displacement, Move...moves) {
    this.displacement = displacement;
    this.mask = Arrays.stream(moves).mapToInt(Move::mask).reduce(0,(i1, i2) -> i1|i2);
  }
}
