package fpc.aoc.year2020.day11.structures;

import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public class SeatLayoutUsingArray implements SeatLayout {

  private final State[] layout;

  private final int width;

  private final int height;

  @Override
  public State stateAt(Position position) {
    return layout[position.linearIndex(width)];
  }

  @Override
  public boolean isFloorAt(Position position) {
    return stateAt(position) == State.FLOOR;
  }

  @Override
  public boolean isEmptySeat(Position position) {
    return stateAt(position) == State.EMPTY_SEAT;
  }

  @Override
  public boolean isOccupiedSeat(Position position) {
    return stateAt(position) == State.OCCUPIED_SEAT;
  }

  @Override
  public long totalNumberOfOccupiedSeats() {
    return Arrays.stream(layout).filter(s -> s == State.OCCUPIED_SEAT).count();
  }
}
