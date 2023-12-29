package fpc.aoc.year2021.day12.struct;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PathCounter {

  public static long count(@NonNull Graph graph, @NonNull RecursiveMode recursiveMode) {
    return new PathCounter(graph, recursiveMode).count();
  }

  private final Graph graph;
  private final RecursiveMode recursiveMode;
  private long nbPaths = 0;

  private long count() {
    count(graph.start());
    return nbPaths;
  }

  private void count(Node position) {
    // invariant: position is not visited and not end
    recursiveMode.onEntering(position);

    for (@NonNull Node connection : graph.getConnections(position)) {
      if (connection.end()) {
        nbPaths += 1;
      } else if (recursiveMode.canVisit(connection)) {
        count(connection);
      }
    }

    recursiveMode.onLeaving(position);

  }
}
