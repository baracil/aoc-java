package fpc.aoc.year2020.day11.structures;

import fpc.aoc.common.Position;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public class SeatLayoutUsingArray implements SeatLayout {

  @Getter
  private final @NonNull State[] layout;

  @Getter
  private final int width;

  @Getter
  private final int height;

  @Override
  public @NonNull State stateAt(@NonNull Position position) {
    return layout[position.linearIndex(width)];
  }

  @Override
  public @NonNull boolean isFloorAt(@NonNull Position position) {
    return stateAt(position) == State.FLOOR;
  }

  @Override
  public @NonNull boolean isEmptySeat(@NonNull Position position) {
    return stateAt(position) == State.EMPTY_SEAT;
  }

  @Override
  public @NonNull boolean isOccupiedSeat(@NonNull Position position) {
    return stateAt(position) == State.OCCUPIED_SEAT;
  }

  @Override
  public long totalNumberOfOccupiedSeats() {
    return Arrays.stream(layout).filter(s -> s == State.OCCUPIED_SEAT).count();
  }
}
