package fpc.aoc.year2019.day3;

import lombok.NonNull;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class Movement {

  @NonNull
  public static Movement parse(String abbreviatedMovement) {
    final Direction direction = Direction.parseDirection(abbreviatedMovement.substring(0, 1));
    final int numberOfSteps = Integer.parseInt(abbreviatedMovement.substring(1));
    return new Movement(direction, numberOfSteps);
  }

  @NonNull Direction direction;
  int numberOfSteps;

  @NonNull
  public List<Point> getPointsFromThisMovement(@NonNull Point startingPoint) {
    final List<Point> points = new ArrayList<>();
    Point current = startingPoint;
    for (int i = 0; i < numberOfSteps; i++) {
      current = direction.move(current);
      points.add(current);
    }
    return points;
  }
}
