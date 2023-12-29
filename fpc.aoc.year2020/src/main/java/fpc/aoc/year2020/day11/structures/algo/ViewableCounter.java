package fpc.aoc.year2020.day11.structures.algo;

import fpc.aoc.common.Displacement;
import fpc.aoc.common.GridHelper;
import fpc.aoc.common.Position;
import fpc.aoc.year2020.day11.structures.AdjacentCounter;
import fpc.aoc.year2020.day11.structures.SeatLayout;
import fpc.aoc.year2020.day11.structures.State;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class ViewableCounter implements AdjacentCounter {

    private final @NonNull GridHelper gridHelper;

    @Override
    public void updateOccupationMap(@NonNull SeatLayout seatLayout, long[] buffer) {
        assert buffer.length == seatLayout.height()*seatLayout.width();
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = countOccupied(seatLayout,gridHelper.positionFor(i));
        }
    }

    private long countOccupied(@NonNull SeatLayout seatLayout, @NonNull Position center) {
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

    private boolean isOccupied(@NonNull SeatLayout seatLayout, @NonNull Position center, @NonNull Displacement displacement) {
        final var visibleState = gridHelper.positionsInDirection(center, displacement)
                                           .map(seatLayout::stateAt)
                                           .filter(s -> s != State.FLOOR)
                                           .findFirst()
                                           .orElse(State.FLOOR);
        return visibleState == State.OCCUPIED_SEAT;
    }

}
