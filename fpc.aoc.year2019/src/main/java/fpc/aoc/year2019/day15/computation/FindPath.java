package fpc.aoc.year2019.day15.computation;

import fpc.aoc.common.Position;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class FindPath {

  public static Map<Position, Integer> computeDistance(Map<Position, TileType> maze, Position start, Position end) {
    return new FindPath(maze, start, end).computeDistance();
  }

  private final Map<Position, TileType> maze;

  private final Position start;

  private final Position end;

  private final Map<Position, Integer> distances = new HashMap<>();

  private final Deque<Position> queue = new LinkedList<>();

  @NonNull
  public Map<Position, Integer> computeDistance() {
    queue.addLast(start);
    distances.put(start, 0);

    while (!queue.isEmpty()) {
      final Position current = queue.removeFirst();
      final int dist = distances.get(current);
      getNeighbours(current).stream()
          .filter(this::usable)
          .forEach(p -> {
            distances.put(p, dist + 1);
            queue.addLast(p);
          });
    }
    return Map.copyOf(distances);
  }

  private boolean usable(Position position) {
    final TileType type = maze.getOrDefault(position, TileType.WALL);
    return !distances.containsKey(position) && type.canWalkThere();
  }

  @NonNull
  private List<Position> getNeighbours(Position center) {
    return List.of(center.translateX(1), center.translateY(-1), center.translateY(1), center.translateX(-1));
  }


}
