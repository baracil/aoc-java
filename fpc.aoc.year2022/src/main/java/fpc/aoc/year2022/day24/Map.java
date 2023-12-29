package fpc.aoc.year2022.day24;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;

public class Map {

  private final ArrayOfChar map;
  private final Blizzards blizzards;

  public Map(ArrayOfChar map) {
    this.map = map;
    this.blizzards = new Blizzards(map);
  }

  public boolean isExit(Position position) {
    return position.x() == map.width() - 2 && position.y() == map.height() - 1;
  }

  public boolean isStart(Position position) {
    return position.x() == 1 && position.y() == 0;
  }

  public boolean canMoveTo(Position position, int turn) {
    if (map.get(position) == '#') {
      return false;
    }

    if (isExit(position)) {
      return true;
    }
    if (isStart(position)) {
      return true;
    }

    return blizzards.canMoveTo(position, turn);
  }

  public boolean canMoveTo(Path path) {
    return canMoveTo(path.position(), path.turn());
  }

  @SuppressWarnings("unused")
  public void dump(int turn) {
    blizzards.dump(turn);
  }
}
