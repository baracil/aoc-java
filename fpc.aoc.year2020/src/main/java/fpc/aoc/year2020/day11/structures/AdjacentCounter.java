package fpc.aoc.year2020.day11.structures;

public interface AdjacentCounter {

  default long[] createBuffer(SeatLayout seatLayout) {
    return new long[seatLayout.width() * seatLayout.height()];
  }

  default long[] updateOccupationMap(SeatLayout seatLayout) {
    final long[] buffer = createBuffer(seatLayout);
    updateOccupationMap(seatLayout, new long[seatLayout.height() * seatLayout.width()]);
    return buffer;
  }

  void updateOccupationMap(SeatLayout seatLayout, long[] buffer);
}
