package fpc.aoc.year2019.day10.computation;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Los {

  public static final Comparator<Los> COMPARE_DIRECTION = (l1, l2) -> {
    if (l1.direction.equals(l2.direction)) {
      return 0;
    }
    return Double.compare(l1.direction.angle(), l2.direction.angle());
  };

  @NonNull
  public static Los create(Direction direction, List<RadialRelativePosition> radialRelativePositions) {
    final List<RadialRelativePosition> asteroids = radialRelativePositions.stream()
        .sorted(RadialRelativePosition.COMPARE_RADIUS).toList();
    return new Los(direction, asteroids);
  }

  @NonNull
  public static Los create(Map.Entry<Direction, List<RadialRelativePosition>> entry) {
    return create(entry.getKey(), entry.getValue());
  }

  @NonNull
  private final Direction direction;

  @NonNull
  private final List<RadialRelativePosition> asteroids;


  public RadialRelativePosition getAsteroid(int position) {
    return asteroids.get(position);
  }

  public int numberOfAsteroid() {
    return asteroids.size();
  }
}
