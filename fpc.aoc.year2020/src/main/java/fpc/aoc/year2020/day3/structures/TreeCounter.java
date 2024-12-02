package fpc.aoc.year2020.day3.structures;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Displacement;
import fpc.aoc.common.Position;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public class TreeCounter {

  private final ArrayOfChar map;

  public long count(Displacement displacement) {

    return Stream.iterate(Position.of(0, 0), p -> p.displaced(displacement))
        .takeWhile(this::isPositionStillOnTheMap)
        .map(this::wrapPositionOnMap)
        .filter(this::isThereATreeAtThisPosition)
        .count();
  }

  private boolean isPositionStillOnTheMap(Position position) {
    return position.y() < map.height();
  }

  private Position wrapPositionOnMap(Position position) {
    return position.wrap(map.width(), map.height());
  }

  private boolean isThereATreeAtThisPosition(Position position) {
    return map.get(position) == '#';
  }
}
