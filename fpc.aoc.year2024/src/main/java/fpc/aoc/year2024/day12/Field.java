package fpc.aoc.year2024.day12;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Orientation;
import fpc.aoc.common.Pair;
import fpc.aoc.common.Position;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

@RequiredArgsConstructor
public class Field {

  private static final Collector<Pair<Character, Plot>, ?, Map<Character, Plots>> COLLECTOR = Collectors.groupingBy(
      Pair::first,
      Collectors.collectingAndThen(Collectors.mapping(Pair::second, Collectors.toList()), Plots::new)
  );


  private final ArrayOfChar map;

  public Map<Character, Plots> findPlots() {
    final var visited = new HashSet<Position>();
    return map.positionStream()
        .filter(not(visited::contains))
        .map(position -> findPlot(position, visited))
        .collect(COLLECTOR);
  }

  private Pair<Character, Plot> findPlot(final Position position, Set<Position> visited) {
    final var plotPositions = new HashSet<Position>();
    final var id = map.get(position);
    final var toVisit = new LinkedList<Position>();
    toVisit.add(position);
    while (!toVisit.isEmpty()) {
      final var p = toVisit.removeFirst();

      if (!visited.add(p)) {
        continue;
      }
      plotPositions.add(p);

      Orientation.allValues().stream()
          .map(p::displaced)
          .filter(not(visited::contains))
          .filter(pos -> map.get(pos) == id)
          .forEach(toVisit::addLast);
    }
    return Pair.of(id, new Plot(plotPositions));
  }
}
