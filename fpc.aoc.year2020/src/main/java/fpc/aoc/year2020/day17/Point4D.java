package fpc.aoc.year2020.day17;

import fpc.aoc.common.NeighbourProvider;
import lombok.Value;

import java.util.stream.Stream;

@Value
public class Point4D implements NeighbourProvider<Point4D> {
  int x;
  int y;
  int z;
  int w;


  public Stream<Point4D> neighbours() {
    final int wp1 = w + 1;
    final int wm1 = w - 1;
    final int zp1 = z + 1;
    final int zm1 = z - 1;
    final int yp1 = y + 1;
    final int ym1 = y - 1;
    final int xp1 = x + 1;
    final int xm1 = x - 1;
    return Stream.of(
        Point4D.of(xp1, yp1, zp1, wp1), Point4D.of(xp1, y, zp1, wp1), Point4D.of(xp1, ym1, zp1, wp1),
        Point4D.of(x, yp1, zp1, wp1), Point4D.of(x, y, zp1, wp1), Point4D.of(x, ym1, zp1, wp1),
        Point4D.of(xm1, yp1, zp1, wp1), Point4D.of(xm1, y, zp1, wp1), Point4D.of(xm1, ym1, zp1, wp1),

        Point4D.of(xp1, yp1, z, wp1), Point4D.of(xp1, y, z, wp1), Point4D.of(xp1, ym1, z, wp1),
        Point4D.of(x, yp1, z, wp1), Point4D.of(x, y, z, wp1), Point4D.of(x, ym1, z, wp1),
        Point4D.of(xm1, yp1, z, wp1), Point4D.of(xm1, y, z, wp1), Point4D.of(xm1, ym1, z, wp1),

        Point4D.of(xp1, yp1, zm1, wp1), Point4D.of(xp1, y, zm1, wp1), Point4D.of(xp1, ym1, zm1, wp1),
        Point4D.of(x, yp1, zm1, wp1), Point4D.of(x, y, zm1, wp1), Point4D.of(x, ym1, zm1, wp1),
        Point4D.of(xm1, yp1, zm1, wp1), Point4D.of(xm1, y, zm1, wp1), Point4D.of(xm1, ym1, zm1, wp1),

        Point4D.of(xp1, yp1, zp1, w), Point4D.of(xp1, y, zp1, w), Point4D.of(xp1, ym1, zp1, w),
        Point4D.of(x, yp1, zp1, w), Point4D.of(x, y, zp1, w), Point4D.of(x, ym1, zp1, w),
        Point4D.of(xm1, yp1, zp1, w), Point4D.of(xm1, y, zp1, w), Point4D.of(xm1, ym1, zp1, w),

        Point4D.of(xp1, yp1, z, w), Point4D.of(xp1, y, z, w), Point4D.of(xp1, ym1, z, w),
        Point4D.of(x, yp1, z, w), /*Point4D.of(x, y, z,w),*/ Point4D.of(x, ym1, z, w),
        Point4D.of(xm1, yp1, z, w), Point4D.of(xm1, y, z, w), Point4D.of(xm1, ym1, z, w),

        Point4D.of(xp1, yp1, zm1, w), Point4D.of(xp1, y, zm1, w), Point4D.of(xp1, ym1, zm1, w),
        Point4D.of(x, yp1, zm1, w), Point4D.of(x, y, zm1, w), Point4D.of(x, ym1, zm1, w),
        Point4D.of(xm1, yp1, zm1, w), Point4D.of(xm1, y, zm1, w), Point4D.of(xm1, ym1, zm1, w),

        Point4D.of(xp1, yp1, zp1, wm1), Point4D.of(xp1, y, zp1, wm1), Point4D.of(xp1, ym1, zp1, wm1),
        Point4D.of(x, yp1, zp1, wm1), Point4D.of(x, y, zp1, wm1), Point4D.of(x, ym1, zp1, wm1),
        Point4D.of(xm1, yp1, zp1, wm1), Point4D.of(xm1, y, zp1, wm1), Point4D.of(xm1, ym1, zp1, wm1),

        Point4D.of(xp1, yp1, z, wm1), Point4D.of(xp1, y, z, wm1), Point4D.of(xp1, ym1, z, wm1),
        Point4D.of(x, yp1, z, wm1), Point4D.of(x, y, z, wm1), Point4D.of(x, ym1, z, wm1),
        Point4D.of(xm1, yp1, z, wm1), Point4D.of(xm1, y, z, wm1), Point4D.of(xm1, ym1, z, wm1),

        Point4D.of(xp1, yp1, zm1, wm1), Point4D.of(xp1, y, zm1, wm1), Point4D.of(xp1, ym1, zm1, wm1),
        Point4D.of(x, yp1, zm1, wm1), Point4D.of(x, y, zm1, wm1), Point4D.of(x, ym1, zm1, wm1),
        Point4D.of(xm1, yp1, zm1, wm1), Point4D.of(xm1, y, zm1, wm1), Point4D.of(xm1, ym1, zm1, wm1)

    );
  }

  public static Point4D of(int x, int y, int z, int w) {
    return new Point4D(x, y, z, w);
  }

  public boolean isNeighbourOf(Point4D point) {
    if (point.equals(this)) {
      return false;
    }
    return isNeighbour(x, point.x)
        & isNeighbour(y, point.y)
        & isNeighbour(z, point.z)
        & isNeighbour(w, point.w);
  }

  private boolean isNeighbour(int v1, int v2) {
    final int dif = v1 - v2;
    return dif == 0 || dif == 1 || dif == -1;
  }
}
