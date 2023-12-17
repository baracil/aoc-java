package fpc.aoc.day17;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Orientation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Helper {

  public static Helper forPart1(ArrayOfChar array) {
      return new Helper(array,0,3,array.width()-1,array.height()-1);
  }

  public static Helper forPart2(ArrayOfChar array) {
    return new Helper(array,4,10,array.width()-1,array.height()-1);
  }


  private final ArrayOfChar array;
  private final int minimalNbSteps;
  private final int maximalNbSteps;
  private final int endX;
  private final int endY;


  public Step move(Step current, Orientation orientation) {

    final var lastOrientation = current.orientation();
    final var newPosition = current.position().displaced(orientation);


    if (orientation == lastOrientation.opposite()) {
      return null;
    }
    final var nb = current.nb();

    if (nb > 0 && nb < minimalNbSteps && orientation != lastOrientation) {
      return null;
    }
    if (nb >= maximalNbSteps && orientation == lastOrientation) {
      return null;
    }
    if (!array.isInside(newPosition)) {
      return null;
    }

    final var heatLoss = array.get(newPosition) - '0';

    final var ref = orientation == lastOrientation ? nb : 0;

    return new Step(newPosition, current.totalHeatLoss() + heatLoss, orientation, ref + 1);
  }

  public boolean endReached(Step step) {
    final var x = step.x();
    final var y = step.y();
    final var n = step.nb();

    return x == endX && y == endY && n>=minimalNbSteps;
  }

}
