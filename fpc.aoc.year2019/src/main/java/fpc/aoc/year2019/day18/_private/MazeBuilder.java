package fpc.aoc.year2019.day18._private;

import fpc.aoc.common.AOCException;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class MazeBuilder {

  @NonNull
  public static Maze create(@NonNull List<String> lines) {
    return new MazeBuilder(lines, false).build();
  }

  @NonNull
  public static Maze splitAndCreate(@NonNull List<String> lines) {
    return new MazeBuilder(lines, true).build();
  }

  @NonNull
  private final List<String> lines;

  private final boolean splitMap;

  private static final char EMPTY = '.';
  private static final char WALL = '#';
  private static final char START = '@';

  private char[] map;


  private int width = 0;

  private int height;

  private final Map<Door, Integer> doors = new HashMap<>();
  private final Map<Key, Integer> keys = new HashMap<>();

  public Maze build() {
    this.validateInputData();
    this.createAndInitializeMap();

    this.fillDeadEnd();
    this.gatherKeysAndDoors();


    final boolean[] walls = new boolean[map.length];
    for (int i = 0; i < walls.length; i++) {
      walls[i] = map[i] == WALL;
    }

    return new Maze(walls, width, height, Map.copyOf(doors), Map.copyOf(keys));
  }

  private void gatherKeysAndDoors() {
    int nbStarts = 0;
    final KeyRepository keyRepository = new KeyRepository();
    for (int i = 0; i < map.length; i++) {
      final char c = map[i];
      final String sc = String.valueOf(c).toLowerCase();
      if (c >= 'a' && c <= 'z') {
        keys.put(keyRepository.get(sc), i);
      } else if (c >= 'A' && c <= 'Z') {
        doors.put(new Door(keyRepository.get(sc)), i);
      } else if (c == START) {
        final Key key = keyRepository.get("@" + nbStarts);
        keys.put(key, i);
        nbStarts++;
      }
    }

  }

  private void fillDeadEnd() {
    this.setDoorInDeadEndAsWall();
    for (int i = 0; i < width * height; i++) {
      int pos = i;
      if (map[i] != EMPTY) {
        continue;
      }
      while (pos >= 0 && map[pos] == EMPTY) {
        int next = deadEndDisplacement(pos);
        if (next >= 0) {
          map[pos] = WALL;
        }
        pos = next;
      }
    }
  }

  private void setDoorInDeadEndAsWall() {
    for (Integer value : doors.values()) {
      if (deadEndDisplacement(value) >= 0) {
        map[value] = WALL;
      }
    }
  }

  /**
   * @param pos the position of a dead end
   * @return the position after the single movement possible in the dead end. -1 if the provided position is not a dead end
   */
  private int deadEndDisplacement(int pos) {
    final int left = pos - 1;
    final int right = pos + 1;
    final int up = pos - width;
    final int down = pos + width;
    final int flag = checkWall(left, 8)
                     + checkWall(right, 4)
                     + checkWall(up, 2)
                     + checkWall(down, 1);

    return switch (flag) {
      case 1 -> down;
      case 2 -> up;
      case 4 -> right;
      case 8 -> left;
      default -> -1;
    };
  }

  private int checkWall(int position, int valueIfFalse) {
    final int v = map[position];
    return (v == WALL) ? 0 : valueIfFalse;
  }

  private void createAndInitializeMap() {
    int i = 0;
    int idxStart = -1;
    this.map = new char[width * height];
    Arrays.fill(this.map, WALL);
    for (int y = 0; y < lines.size(); y++) {
      String line = lines.get(y);
      for (int x = 0; x < line.length(); x++) {
        final char c = line.charAt(x);
        if (c == START) {
          idxStart = i;
        }
        map[i++] = c;
      }
    }
    if (splitMap && idxStart < 0) {
      throw new AOCException("Invalid input. Missing starting point");
    } else if (splitMap) {
      map[idxStart] = WALL;
      map[idxStart - 1] = WALL;
      map[idxStart + 1] = WALL;
      map[idxStart + width] = WALL;
      map[idxStart - width] = WALL;
      map[idxStart + width + 1] = START;
      map[idxStart + width - 1] = START;
      map[idxStart - width + 1] = START;
      map[idxStart - width - 1] = START;
    }
  }

  private void validateInputData() {
    final IntSummaryStatistics statistics = lines.stream().mapToInt(String::length).summaryStatistics();

    if (statistics.getMax() != statistics.getMin()) {
      throw new AOCException("Invalid input data");
    }

    this.width = statistics.getMax();
    this.height = lines.size();
  }


}
