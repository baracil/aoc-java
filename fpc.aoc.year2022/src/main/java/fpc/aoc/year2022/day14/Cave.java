package fpc.aoc.year2022.day14;

import fpc.aoc.common.Position;

import java.io.PrintStream;
import java.util.Map;

public class Cave {

  private final Map<Position, Type> types;
  private final int lowerRock;

  public Cave(Map<Position, Type> types) {
    this.types = types;
    this.lowerRock = types.keySet().stream().mapToInt(Position::y).max().orElse(0);
  }

  /**
   * @return true if sand can still be dropped
   */
  public boolean dropSandPart1() {
    var position = Position.of(500, 0);

    do {
      final var new_position = computeFallingPosition(position);
      if (new_position == null) {
        types.put(position, Type.SAND);
        break;
      } else {
        if (new_position.y() >= lowerRock) {
          return false;
        }
        position = new_position;
      }
    } while (true);
    return true;
  }

  /**
   * @return true if sand can still be dropped
   */
  public boolean dropSandPart2() {
    var position = Position.of(500, 0);
    if (types.containsKey(position)) {
      return false;
    }

    do {
      final var new_position = computeFallingPosition(position);
      if (new_position == null || new_position.y() == lowerRock + 2) {
        types.put(position, Type.SAND);
        return true;
      } else {
        position = new_position;
      }
    } while (true);
  }

  private Position computeFallingPosition(Position position) {
    final var lower = position.translate(0, 1);
    if (!types.containsKey(lower)) {
      return lower;
    }
    final var left = position.translate(-1, 1);
    if (!types.containsKey(left)) {
      return left;
    }
    final var right = position.translate(1, 1);
    if (!types.containsKey(right)) {
      return right;
    }
    return null;
  }

  public void display(PrintStream ps) {
    final var my = types.keySet().stream().mapToInt(Position::y).summaryStatistics();
    final var mx = types.keySet().stream().mapToInt(Position::x).summaryStatistics();

    ps.println();
    for (int y = 0; y <= my.getMax(); y++) {
      for (int x = mx.getMin(); x <= mx.getMax(); x++) {
        final var type = types.getOrDefault(Position.of(x, y), Type.EMPTY);
        ps.print(type.chr());
      }
      ps.println();
    }
  }

}
