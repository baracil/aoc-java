package fpc.aoc.year2022.day22;

import fpc.aoc.common.Position;

public class TestUnFold implements UnFold {

  private final int width = 4;

  @Override
  public Move findNext(Position position, Orientation orientation) {
    final var quadrant = 10 * (position.x() / width) + (position.y() / width);
    return switch (orientation) {
      case RIGHT -> findRight(position, quadrant);
      case LEFT -> findLeft(position, quadrant);
      case UP -> findUp(position, quadrant);
      case DOWN -> findDown(position, quadrant);
    };
  }

  private Move findRight(Position position, int quadrant) {
    if ((position.x() + 1) % width != 0) {
      return Move.displaced(position, Orientation.RIGHT);
    }
    final var my = position.y() % width;
    return switch (quadrant) {
      case 20 -> new Move(new Position(width * 4 - 1, width * 3 - 1 - my), Orientation.LEFT);
      case 21 -> new Move(width * 4 - 1 - my, width * 2, Orientation.DOWN);
      case 32 -> new Move(width * 3 - 1, 4 - 1 - my, Orientation.LEFT);
      default -> Move.displaced(position, Orientation.RIGHT);
    };
  }

  private Move findLeft(Position position, int quadrant) {
    if (position.x() % width != 0) {
      return Move.displaced(position, Orientation.LEFT);
    }
    final var my = position.y() % width;
    return switch (quadrant) {
      case 20 -> new Move(width + my, width, Orientation.DOWN);
      case 1 -> new Move(width * 4 - 1 - my, width * 3 - 1, Orientation.UP);
      case 22 -> new Move(width * 2 - 1 - my, width * 2 - 1, Orientation.UP);
      default -> Move.displaced(position, Orientation.LEFT);
    };
  }

  private Move findUp(Position position, int quadrant) {
    if (position.y() % width != 0) {
      return Move.displaced(position, Orientation.UP);
    }
    final var mx = position.x() % width;
    return switch (quadrant) {
      case 20 -> new Move(width - 1 - mx, width, Orientation.DOWN);
      case 1 -> new Move(width * 3 - 1 - mx, 0, Orientation.DOWN);
      case 11 -> new Move(width * 2, mx, Orientation.RIGHT);
      case 32 -> new Move(width * 3 - 1, width * 2 - 1 - mx, Orientation.LEFT);
      default -> Move.displaced(position, Orientation.UP);
    };
  }

  private Move findDown(Position position, int quadrant) {
    if ((position.y() + 1) % width != 0) {
      return Move.displaced(position, Orientation.DOWN);
    }
    final var mx = position.x() % width;
    return switch (quadrant) {
      case 1 -> new Move(width * 3 - 1 - mx, width * 3 - 1, Orientation.UP);
      case 11 -> new Move(width * 2, width * 3 - 1 - mx, Orientation.RIGHT);
      case 22 -> new Move(width - 1 - mx, width * 2 - 1, Orientation.UP);
      case 32 -> new Move(0, width * 2 - 1 - mx, Orientation.RIGHT);
      default -> Move.displaced(position, Orientation.DOWN);
    };
  }
}
