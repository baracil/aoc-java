package fpc.aoc.year2022.day18;


import java.util.*;
import java.util.stream.Collectors;

public class Expander {

  private final Map<Point,Face> facePositions;

  private final int xmin;
  private final int xmax;
  private final int ymin;
  private final int ymax;
  private final int zmin;
  private final int zmax;

  public Expander(Set<Face> faces) {
    this.facePositions = faces.stream().collect(Collectors.toMap(Face::center, f -> f));
    final var xStat = faces.stream().mapToInt(f -> f.center().x()).summaryStatistics();
    final var yStat = faces.stream().mapToInt(f -> f.center().y()).summaryStatistics();
    final var zStat = faces.stream().mapToInt(f -> f.center().z()).summaryStatistics();

    xmin = toEven(xStat.getMin() - 4);
    xmax = toEven(xStat.getMax() + 4);
    ymin = toEven(yStat.getMin() - 4);
    ymax = toEven(yStat.getMax() + 4);
    zmin = toEven(zStat.getMin() - 4);
    zmax = toEven(zStat.getMax() + 4);
  }

  private static int toEven(int value) {
    return (value>>1)<<1;
  }

  public Set<Face> expand() {
    final Set<Face> touchedFaces = new HashSet<>();
    final Deque<Point> toVisit = new LinkedList<>();
    final Set<Point> visited = new HashSet<>();

    final var start = new Point(xmin+2,ymin+2,zmin+2);
    toVisit.addLast(start);
    visited.add(start);
    do {
      final var next = toVisit.pollFirst();
      if (next == null) {
        break;
      }

      Disp.allValues()
          .forEach(disp -> {
            final var half = next.add(disp);
            final var full = half.add(disp);
            final var face = facePositions.get(half);
            if (face != null) {
              touchedFaces.add(face);
            } else if (!visited.contains(full) && !outsideLimits(full)) {
              toVisit.add(full);
              visited.add(full);
            }
          });

    } while (true);

    return touchedFaces;
  }

  private boolean outsideLimits(Point p) {
    return p.x()<=xmin || p.x()>=xmax
        ||p.y()<=ymin || p.y()>=ymax
        ||p.z()<=zmin || p.z()>=zmax;
  }

}
