package fpc.aoc.common;

import lombok.NonNull;

import java.util.stream.Stream;

/**
 * Provides methods to get some positions on a grid
 */
public interface GridHelper {

  static @NonNull GridHelper create(int width, int height) {
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
  @NonNull Stream<Position> allAdjacentPosition(@NonNull Position center);

  @NonNull Stream<Position> allCardinalNeighbours(@NonNull Position center);

  @NonNull Stream<Position> allPositionOnGrid();

  int linearIndexFor(@NonNull Position position);

  int linearIndexFor(int x, int y);

  @NonNull Position positionFor(int linearIndex);

  @NonNull Stream<Position> positionsInDirection(@NonNull Position center, @NonNull Displacement displacement);

  boolean isOnBorder(Position position);

  boolean isInside(Position p);
}
