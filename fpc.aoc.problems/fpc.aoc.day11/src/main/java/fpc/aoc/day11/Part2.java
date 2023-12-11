package fpc.aoc.day11;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;

import java.util.ArrayList;
import java.util.List;

public class Part2 {

  public static long find(ArrayOfChar map) {
    return new Part2(map).find();
  }

  private final ArrayOfChar map;
  private List<Position> galaxies = new ArrayList<>();
  private boolean[] emptyRow;
  private boolean[] emptyColumn;

  private Part2(ArrayOfChar map) {
    this.map = map;
    this.emptyRow = new boolean[map.height()];
    this.emptyColumn = new boolean[map.width()];
    for (int y = 0; y < map.height(); y++) {
      emptyRow[y] = true;
      for (int x = 0; x < map.width(); x++) {
        emptyRow[y] = emptyRow[y] && map.get(x, y) == '.';
        if (map.get(x, y) == '#') {
          galaxies.add(new Position(x, y));
        }
      }
    }
    for (int x = 0; x < map.width(); x++) {
      emptyColumn[x] = true;
      for (int y = 0; y < map.height(); y++) {
        emptyColumn[x] = emptyColumn[x] && map.get(x, y) == '.';
      }
    }
  }

  private long find() {
    long sum = 0L;
    for (int i = 0; i < galaxies.size(); i++) {
      for (int j = i+1; j < galaxies.size(); j++) {
        sum += distance(galaxies.get(i), galaxies.get(j));
      }
    }
    return sum;
  }

  private long distance(Position p1, Position p2) {
    long dist = 0;
    int minx = Math.min(p1.x(), p2.x());
    int miny = Math.min(p1.y(), p2.y());
    int maxx = Math.max(p1.x(), p2.x());
    int maxy = Math.max(p1.y(), p2.y());

    for (int i = minx + 1; i <= maxx; i++) {
      dist += 1;
      if (emptyColumn[i]) {
        dist += 999999;
      }
    }
    for (int i = miny + 1; i <= maxy; i++) {
      dist += 1;
      if (emptyRow[i]) {
        dist += 999999;
      }
    }
    return dist;
  }
}
