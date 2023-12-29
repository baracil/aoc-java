package fpc.aoc.year2020.day11.structures;

import lombok.NonNull;

public interface AdjacentCounter {

    default long[] createBuffer(@NonNull SeatLayout seatLayout) {
        return new long[seatLayout.width()*seatLayout.height()];
    }

    default long[] updateOccupationMap(@NonNull SeatLayout seatLayout) {
        final long[] buffer = createBuffer(seatLayout);
        updateOccupationMap(seatLayout, new long[seatLayout.height() * seatLayout.width()]);
        return buffer;
    }

    void updateOccupationMap(@NonNull SeatLayout seatLayout, long[] buffer);
}
