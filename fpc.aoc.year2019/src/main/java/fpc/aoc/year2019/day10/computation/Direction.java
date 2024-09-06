package fpc.aoc.year2019.day10.computation;

import fpc.aoc.common.Tools;
import lombok.*;

@Value
@EqualsAndHashCode(of = {"dx", "dy"})
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Direction {

  @NonNull
  public static Direction create(int x, int y) {
    if (x == 0 && y == 0) {
      return new Direction(0, 0, 0);
    }

    final int gcd = Tools.gcd(Math.abs(x), Math.abs(y));
    return new Direction(x / gcd, y / gcd, (4 + 2 * Math.atan2(x, -y) / Math.PI) % 4);
  }

  int dx;

  int dy;

  double angle;

  public boolean isNotNil() {
    return dx != 0 || dy != 0;
  }


}
