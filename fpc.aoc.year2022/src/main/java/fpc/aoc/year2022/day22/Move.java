package fpc.aoc.year2022.day22;

import fpc.aoc.common.Position;
import lombok.RequiredArgsConstructor;
import lombok.Value;


@Value
@RequiredArgsConstructor
public class Move {
  Position position;
  Orientation orientation;

  public Move(int x, int y, Orientation orientation) {
    this.position = new Position(x, y);
    this.orientation = orientation;
  }

  public static Move displaced(Position position, Orientation orientation) {
    return new Move(position.displaced(orientation.displacement()), orientation);
  }

}
