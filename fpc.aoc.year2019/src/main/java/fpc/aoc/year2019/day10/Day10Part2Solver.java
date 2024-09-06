package fpc.aoc.year2019.day10;

import fpc.aoc.api.Solver;
import fpc.aoc.year2019.day10.computation.AsteroidField;
import fpc.aoc.year2019.day10.computation.Base;
import fpc.aoc.year2019.day10.computation.VisibilityMap;
import lombok.NonNull;

/**
 * @author perococco
 **/
public class Day10Part2Solver extends Day10Solver {

  public static Solver provider() {
    return new Day10Part2Solver();
  }

  @Override
  protected @NonNull Object doSolve(@NonNull AsteroidField asteroidField) {
    final Base base = asteroidField.findOptimalBase();
    final VisibilityMap visibilityMap = asteroidField.createVisibilityMapFrom(base.position());

    final var destroy200th = visibilityMap.destructionOrder().get(199);

    return destroy200th.x() * 100 + destroy200th.y();
  }
}
