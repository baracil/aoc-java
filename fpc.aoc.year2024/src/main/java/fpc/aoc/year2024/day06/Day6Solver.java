package fpc.aoc.year2024.day06;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Orientation;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.RequiredArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@RequiredArgsConstructor
public abstract class Day6Solver extends SmartSolver<ArrayOfChar> {

  public static final char BORDER = 'X';

  @Override
  protected Converter<ArrayOfChar> getConverter() {
    return l -> ArrayOfChar.from(l, BORDER);
  }

  @Override
  protected final Object doSolve(ArrayOfChar input) {
    final var guardPosition = input.findMatching('^').orElseThrow(() -> new AOCException("No guard defined"));
    return doSolve(input, new Guard(guardPosition, Orientation.N));
  }

  protected abstract Object doSolve(ArrayOfChar map, Guard guard);

  protected Set<Guard> getVisited(ArrayOfChar map, Guard start) {
    final var visited = new LinkedHashSet<Guard>();
    var current = start;
    while (current != null) {
      visited.add(current);
      current = current.move(map);
    }
    return visited;
  }
}
