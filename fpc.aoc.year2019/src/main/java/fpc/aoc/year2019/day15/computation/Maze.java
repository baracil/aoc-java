package fpc.aoc.year2019.day15.computation;

import fpc.aoc.common.Position;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.IntSummaryStatistics;
import java.util.Map;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Maze {

  @NonNull
  @Getter
  private final Position start;

  @NonNull
  @Getter
  private final Position end;

  private final boolean[][] map;

  @Getter
  private final int width;

  @Getter
  private final int height;

  public boolean isWall(Position position) {
    return map[position.x()][position.y()];
  }

  public void print() {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        if (x == start.x() && y == start.y()) {
          System.out.print("S");
        } else if (x == end.x() && y == end.y()) {
          System.out.print("X");
        } else {
          System.out.printf("%s", map[x][y] ? "\u2588" : " ");
        }
      }
      System.out.println();
    }
  }


  @NonNull
  public static Maze create(Map<Position, TileType> memory) {
    final IntSummaryStatistics statX = memory.keySet().stream().mapToInt(Position::x).summaryStatistics();
    final IntSummaryStatistics statY = memory.keySet().stream().mapToInt(Position::y).summaryStatistics();

    final int width = statX.getMax() - statX.getMin() + 1;
    final int height = statY.getMax() - statY.getMin() + 1;

    Position oxygen = null;
    Position first = null;

    final boolean[][] maze = new boolean[width][height];

    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        final Position position = Position.of(i + statX.getMin(), j + statY.getMin());
        final TileType tileType = memory.getOrDefault(position, TileType.UNKNOWN);
        maze[i][j] = !tileType.canWalkThere();

        if (tileType == TileType.OXYGEN) {
          oxygen = position;
        } else if (tileType == TileType.START) {
          first = position;
        }
      }
    }

    assert first != null;
    assert oxygen != null;

    final Position start = Position.of(first.x() - statX.getMin(), first.y() - statY.getMin());
    final Position end = Position.of(oxygen.x() - statX.getMin(), oxygen.y() - statY.getMin());

    return new Maze(start, end, maze, width, height);
  }

}
