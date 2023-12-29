package fpc.aoc.year2022.day12;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.GridHelper;
import fpc.aoc.common.Position;
import lombok.NonNull;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PathFinder {

  private final GridHelper gridHelper;
  private final ArrayOfChar heights;
  private final PathInfo pathInfo;


  public PathFinder(ArrayOfChar heights, PathInfo pathInfo) {
    this.heights = heights;
    this.gridHelper = GridHelper.create(heights.width(), heights.height());
    this.pathInfo = pathInfo;
  }


  public @NonNull Path findShortestPath() {
    final Deque<Path> toProcess = new LinkedList<>();
    final Set<Position> visitedPositions = new HashSet<>();

    final var startingPosition = pathInfo.startingPosition(heights);

    toProcess.addLast(new Path(startingPosition, 0));
    visitedPositions.add(startingPosition);

    while (true) {
      final var path = toProcess.pollFirst();
      if (path == null) {
        throw new AOCException("Could find a path to E");
      }

      final var pos = path.position();
      if (pathInfo.isTargetReached(heights.get(pos))) {
        return path;
      }

      final var heightAtPos = height(pos);

      gridHelper.allCardinalNeighbours(pos)
          .filter(p -> pathInfo.isReachable(heightAtPos, height(p)) && !visitedPositions.contains(p))
          .forEach(p -> {
            toProcess.addLast(path.withNewStep(p));
            visitedPositions.add(p);
          });
    }
  }

  private int height(@NonNull Position position) {
    final var h = heights.get(position);
    return h == 'E' ? 'z' : h == 'S' ? 'a' : h;
  }


}

