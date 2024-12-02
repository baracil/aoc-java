package fpc.aoc.year2020.day11.structures.algo;

import fpc.aoc.common.Displacement;
import fpc.aoc.common.GridHelper;
import fpc.aoc.common.Position;
import fpc.aoc.year2020.day11.structures.AdjacentCounter;
import fpc.aoc.year2020.day11.structures.SeatLayout;
import fpc.aoc.year2020.day11.structures.State;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class OptimizedViewableCounter implements AdjacentCounter {

  private final GridHelper gridHelper;

  @Override
  public void updateOccupationMap(SeatLayout seatLayout, long[] buffer) {
    assert buffer.length == seatLayout.height() * seatLayout.width();
    Arrays.fill(buffer, 0);
    for (int i = 0; i < buffer.length; i++) {
      final Position position = gridHelper.positionFor(i);
      final var testState = seatLayout.stateAt(position);
      final var testIndex = i;
      if (testState == State.FLOOR) {
        continue;
      }

      Stream.of(Displacement.E, Displacement.SE, Displacement.S, Displacement.SW)
          .map(disp -> findSeatPosition(seatLayout, position, disp))
          .filter(Objects::nonNull)
          .forEach(p -> {
            final State viewState = seatLayout.stateAt(p);
            if (viewState == State.OCCUPIED_SEAT) {
              buffer[testIndex]++;
            }
            if (testState == State.OCCUPIED_SEAT) {
              buffer[gridHelper.linearIndexFor(p)]++;
            }
          });
    }
  }

  private Position findSeatPosition(SeatLayout seatLayout, Position position, Displacement displacement) {
    return gridHelper.positionsInDirection(position, displacement)
        .filter(seatLayout::isNotFloor)
        .findFirst()
        .orElse(null);
  }

  private long countOccupied(SeatLayout seatLayout, Position center) {
    final Predicate<Displacement> seatOccupiedInDirection = d -> isOccupied(seatLayout, center, d);
    return Stream.of(Displacement.N,
            Displacement.E,
            Displacement.S,
            Displacement.W,
            Displacement.NE,
            Displacement.NW,
            Displacement.SE,
            Displacement.SW)
        .filter(seatOccupiedInDirection)
        .count();
  }

  private boolean isOccupied(SeatLayout seatLayout, Position center, Displacement displacement) {
    final var visibleState = gridHelper.positionsInDirection(center, displacement)
        .map(seatLayout::stateAt)
        .filter(s -> s != State.FLOOR)
        .findFirst()
        .orElse(State.FLOOR);
    return visibleState == State.OCCUPIED_SEAT;
  }

}
