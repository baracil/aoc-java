package fpc.aoc.year2024.day08;

import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Pair;
import fpc.aoc.common.Position;
import fpc.aoc.common.Tools;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class AntiNodeCounter {

  public static long countAntiNodesForPart1(ArrayOfChar map) {
    return new AntiNodeCounter(map, true).countAntiNodes();
  }

  public static long countAntiNodesForPart2(ArrayOfChar map) {
    return new AntiNodeCounter(map, false).countAntiNodes();
  }


  private final ArrayOfChar map;
  private final boolean part1;

  private long countAntiNodes() {
    final var antennaByFrequency = this.collectAntennaByFrequency();
    return antennaByFrequency
        .values()
        .stream()
        .flatMap(this::findAntiNodes)
        .distinct()
        .count();
  }

  private Map<Character, Set<Position>> collectAntennaByFrequency() {
    return map.positionStream()
        .filter(p -> map.get(p) != '.')
        .collect(Collectors.groupingBy(map::get, Collectors.toSet()));
  }

  private Stream<Position> findAntiNodes(Collection<Position> sameFrequencyAntenna) {
    return Tools.zip(sameFrequencyAntenna, sameFrequencyAntenna)
        .flatMap(this::findAntiNodeForOnePair);
  }

  private Stream<Position> findAntiNodeForOnePair(Pair<Position, Position> pair) {
    final var reference = pair.first();
    final var other = pair.second();
    final var dx = other.x() - reference.x();
    final var dy = other.y() - reference.y();
    if (dx == 0 && dy == 0) {
      return Stream.empty();
    }

    return getMultipleStream()
        .mapToObj(i -> other.translate(dx * i, dy * i))
        .takeWhile(this::inMap);
  }

  private IntStream getMultipleStream() {
    if (part1) {
      return IntStream.of(1);
    } else {
      return IntStream.range(0, Integer.MAX_VALUE);
    }
  }

  private boolean inMap(Position p) {
    return map.get(p) != Day8Solver.OUT_SIDE;
  }

}
