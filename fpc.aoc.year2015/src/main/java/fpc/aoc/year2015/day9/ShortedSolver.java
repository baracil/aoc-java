package fpc.aoc.year2015.day9;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

class ShortedSolver {

  private final Input input;

  @Getter
  private int best = Integer.MAX_VALUE;

  public ShortedSolver(Input input) {
    this.input = input;
  }

  public void process(String start) {
    final var visited = new HashSet<String>();
    visited.add(start);
    process(visited, start, 0);
  }

  private void process(Set<String> visited, String last, int distance) {
    if (distance>=best) {
      return;
    }
    if (visited.size() == input.size()) {
      best = distance;
      return;
    }

    final var connected = input.findConnected(last);

    for (Path p : connected) {
      final var next = p.end();
      if (visited.contains(next)) {
        continue;
      }
      visited.add(next);
      process(visited, next, distance + p.length());
      visited.remove(next);
    }
  }
}
