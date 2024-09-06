package fpc.aoc.year2019.day3;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.Lazy;
import fpc.aoc.common.Tools;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Path {

  @NonNull
  @Getter
  private final List<Point> points;

  private final Lazy<Map<Point, Integer>> numberOfStepsToPoint;

  public Path() {
    this(List.of(Point.CENTRAL_PORT));
  }

  private Path(@NonNull List<Point> points) {
    if (points.isEmpty()) {
      throw new AOCException("A Path is made of at least 1 point");
    }
    this.points = points;
    this.numberOfStepsToPoint = new Lazy<>(() -> Tools.mapSmallestIndexInList(points));
  }

  @NonNull
  private Point getLastPoint() {
    return points.get(points.size() - 1);
  }

  @NonNull
  public Path complete(@NonNull Movement movement) {
    final var newPoints = movement.getPointsFromThisMovement(getLastPoint());
    return new Path(Tools.mergeLists(points, newPoints));
  }

  public int numberOfStepsToReach(@NonNull Point point) {
    final Integer nbSteps = numberOfStepsToPoint.get().get(point);
    return nbSteps == null ? Integer.MAX_VALUE / 2 : nbSteps;
  }

  @NonNull
  public static Stream<Point> intersectionStream(@NonNull Path path1, @NonNull Path path2) {
    final Set<Point> path2Points = path2.numberOfStepsToPoint.get().keySet();
    return path1.points.stream()
        .filter(Point::isNotCentralPort)
        .filter(path2Points::contains);
  }


}
