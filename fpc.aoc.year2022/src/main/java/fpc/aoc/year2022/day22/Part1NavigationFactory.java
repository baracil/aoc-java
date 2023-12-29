package fpc.aoc.year2022.day22;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;

public class Part1NavigationFactory extends BaseNavigationFactory {

  public Part1NavigationFactory(ArrayOfChar map) {
    super(map);
  }

  protected Move findNext(Position position, Orientation orientation) {
      var p = position;
      do {
        p = p.displaced(orientation.displacement()).wrap(map.width(), map.height());
        if (isNotSpace(p)) {
          return new Move(p,orientation);
        }
      } while (true);
    }

}
