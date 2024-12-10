package fpc.aoc.year2024.day10;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Orientation;
import fpc.aoc.common.Position;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class Map {


  private final ArrayOfChar map;

  public List<Position> findStartingPositions() {
    return map.findAllMatching('0');
  }

  public Stream<Position> findNextAllowed(Position current) {
    final var currentValue = map.get(current);
    return Orientation
        .allValues()
        .stream()
        .map(current::displaced)
        .filter(p -> (map.get(p) - currentValue)==1);
  }

  public boolean isAtEndOfTrail(Position position) {
    return map.get(position) == '9';
  }
}
