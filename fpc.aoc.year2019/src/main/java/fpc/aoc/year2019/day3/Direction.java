package fpc.aoc.year2019.day3;

import fpc.aoc.common.AOCException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Direction {
  UP("U", Point::pointAbove),
  DOWN("D", Point::pointBelow),
  LEFT("L", Point::pointOnTheLeft),
  RIGHT("R", Point::pointOnTheRight),
  ;

  @NonNull
  private final String abbreviation;

  private final UnaryOperator<Point> singleStepMovement;

  @NonNull
  public Point move(Point point) {
    return singleStepMovement.apply(point);
  }

  @NonNull
  public static Direction parseDirection(String abbreviation) {
    final Direction direction = Holder.DIRECTIONS_BY_ABBREVIATION.get(abbreviation.toUpperCase());
    if (direction == null) {
      throw new AOCException("Invalid abbreviation '" + abbreviation + "' for a direction");
    }
    return direction;
  }

  private static class Holder {

    private static final Map<String, Direction> DIRECTIONS_BY_ABBREVIATION;

    static {
      DIRECTIONS_BY_ABBREVIATION = Arrays.stream(values()).collect(Collectors.toMap(d -> d.abbreviation, d -> d));
    }
  }
}
