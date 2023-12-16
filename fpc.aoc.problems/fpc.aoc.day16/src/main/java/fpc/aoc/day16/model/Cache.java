package fpc.aoc.day16.model;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;
import fpc.aoc.day16.Beam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cache {
  private final Map<Position, Set<Beam>> seen = new HashMap<>();

  public boolean put(Beam beam) {
    return seen.computeIfAbsent(beam.position(), b -> new HashSet<>()).add(beam);
  }

  public long size() {
    return seen.size();
  }

  public void display(ArrayOfChar map) {
    for (int y = 0; y < map.height(); y++) {
      for (int x = 0; x < map.width(); x++) {
        final var c = map.get(x, y);
        if (c == '.') {
          final var s = seen.get(Position.of(x, y));
          if (s == null || s.isEmpty()) {
            System.out.print(c);
          } else if (s.size() != 1) {
            System.out.print(s.size());
          } else {
            final var next = s.iterator().next().orientation();
            final var cc = switch (next) {
              case N -> '^';
              case E -> '>';
              case S -> 'V';
              case W -> '<';
            };
            System.out.print(cc);
          }
        } else {
          System.out.print(c);
        }
      }
      System.out.println();
    }
  }
}
