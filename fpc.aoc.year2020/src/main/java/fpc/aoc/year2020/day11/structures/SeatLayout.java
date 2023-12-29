package fpc.aoc.year2020.day11.structures;

import fpc.aoc.common.Position;
import lombok.NonNull;

public interface SeatLayout {

    int width();
    int height();

    @NonNull State stateAt(@NonNull Position position);
    @NonNull boolean isFloorAt(@NonNull Position position);
    @NonNull boolean isEmptySeat(@NonNull Position position);
    @NonNull boolean isOccupiedSeat(@NonNull Position position);

    default @NonNull boolean isNotFloor(@NonNull Position position) {
        return !isFloorAt(position);
    }

    long totalNumberOfOccupiedSeats();



}
