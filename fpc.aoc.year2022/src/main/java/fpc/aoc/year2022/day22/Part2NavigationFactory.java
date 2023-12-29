package fpc.aoc.year2022.day22;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;

public class Part2NavigationFactory extends BaseNavigationFactory {

  private final UnFold unFold;

  public Part2NavigationFactory(ArrayOfChar map) {
    super(map);
    if (map.width()<=16) {
      unFold = new TestUnFold();
    } else {
      unFold = new SampleUnFold();
    }
  }

  @Override
  protected Move findNext(Position position, Orientation orientation) {
    return unFold.findNext(position, orientation);
  }
}
