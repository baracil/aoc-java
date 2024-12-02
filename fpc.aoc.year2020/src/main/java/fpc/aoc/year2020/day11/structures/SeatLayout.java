package fpc.aoc.year2020.day11.structures;

import fpc.aoc.common.Position;
import lombok.NonNull;

public interface SeatLayout {

  int width();

  int height();

  @NonNull
  State stateAt(Position position);

  @NonNull
  boolean isFloorAt(Position position);

  @NonNull
  boolean isEmptySeat(Position position);

  @NonNull
  boolean isOccupiedSeat(Position position);

  default boolean isNotFloor(Position position) {
    return !isFloorAt(position);
  }

  long totalNumberOfOccupiedSeats();


}
