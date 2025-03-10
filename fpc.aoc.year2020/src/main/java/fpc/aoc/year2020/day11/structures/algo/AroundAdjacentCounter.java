package fpc.aoc.year2020.day11.structures.algo;

import fpc.aoc.common.GridHelper;
import fpc.aoc.common.Position;
import fpc.aoc.year2020.day11.structures.AdjacentCounter;
import fpc.aoc.year2020.day11.structures.SeatLayout;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AroundAdjacentCounter implements AdjacentCounter {

  private final GridHelper gridHelper;

  @Override
  public void updateOccupationMap(SeatLayout seatLayout, long[] buffer) {
    assert buffer.length == seatLayout.height() * seatLayout.width();
    for (int i = 0; i < buffer.length; i++) {
      buffer[i] = countOccupied(seatLayout, gridHelper.positionFor(i));
    }
  }

  private long countOccupied(SeatLayout seatLayout, Position center) {
    return gridHelper.allAdjacentPosition(center)
        .filter(seatLayout::isOccupiedSeat)
        .count();
  }
}
