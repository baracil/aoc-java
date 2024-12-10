package fpc.aoc.year2024.day10;

import fpc.aoc.common.Position;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.function.Predicate.not;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ValueCalculator {


  public static int computeScore(Map map, Position startingPosition) {
    return new ValueCalculator(map,startingPosition,s -> not(s::contains)).computeValue();
  }

  public static int computeRating(Map map, Position startingPosition) {
    return new ValueCalculator(map,startingPosition, _ -> _ -> true).computeValue();
  }

  private final Map map;
  private final Position startingPosition;
  private final Function<Set<Position>,Predicate<Position>> validatorFactory;

  private int computeValue() {
    int value = 0;
    final var visited = new HashSet<Position>();
    final var filter = validatorFactory.apply(visited);
    final Deque<Position> toVisit = new LinkedList<>();
    toVisit.add(startingPosition);

    while (!toVisit.isEmpty()) {
      final var position = toVisit.removeFirst();
      visited.add(position);
      if (map.isAtEndOfTrail(position)) {
        value++;
      } else {
        map.findNextAllowed(position)
            .filter(filter)
            .forEach(toVisit::addFirst);
      }
    }
    return value;
  }
}
