package fpc.aoc.year2022.day22;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Map {
  private final ArrayOfChar map;
  private final Navigation navigation;

  public Player start() {
    return new Player(navigation.start(), Orientation.RIGHT);
  }

  public Move next(Position position, Orientation orientation) {
//        return new TestUnFold().findNext(position,orientation);
    return navigation.next(position, orientation);
  }

  public boolean isWall(Position position) {
    return map.get(position) == '#';
  }
}
