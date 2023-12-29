package fpc.aoc.year2022.day22;

import fpc.aoc.common.Position;
import lombok.Value;

@Value
public class Player {

  Position position;
  Orientation orientation;

  public Player move(Map map, int nbSteps) {
    var current = new Move(position, orientation);
    for (int i = 0; i < nbSteps; i++) {
      final var next = map.next(current.position(), current.orientation());
      if (map.isWall(next.position())) {
        break;
      }
      current = next;
    }
    return new Player(current.position(), current.orientation());
  }

  public Player rotateR() {
    return new Player(position, orientation.clockwise());
  }

  public Player rotateL() {
    return new Player(position, orientation.antiClockwise());
  }

  public int getValue() {
    final var row = 1000 * (position.y() + 1);
    final var col = 4 * (position.x() + 1);
    final var facing = orientation.value();
    return row + col + facing;
  }
}
