package fpc.aoc.common;

import java.util.stream.Stream;

/**
 * Provides methods to get some positions on a grid
 */
public interface GridHelper {

  static GridHelper create(int width, int height) {
    return new SimpleGridHelper(width, height);
  }

  /**
   * @return the width of the grip
   */
  int width();

  /**
   * @return the height of the grip
   */
  int height();

  /**
   * @param center the central position
   * @return all the position around the provided position (taking care of border)
   */
  Stream<Position> allAdjacentPosition(Position center);

  Stream<Position> allCardinalNeighbours(Position center);

  Stream<Position> allPositionOnGrid();

  int linearIndexFor(Position position);

  int linearIndexFor(int x, int y);

  Position positionFor(int linearIndex);

  Stream<Position> positionsInDirection(Position center, Displacement displacement);

  boolean isOnBorder(Position position);

  boolean isInside(Position p);
}
