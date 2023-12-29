package fpc.aoc.year2020.day11.structures.algo;

import fpc.aoc.year2020.day11.structures.State;
import fpc.aoc.year2020.day11.structures.StateEvolutionRule;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WithLeavingThresholdRule implements StateEvolutionRule {

    private final long occupiedThresholdWhenLeaving;

    @Override
    public @NonNull State evaluateNewSate(@NonNull State current, long numberOfAdjacentOccupiedSeats) {
        return switch (current) {
            case OCCUPIED_SEAT -> numberOfAdjacentOccupiedSeats<occupiedThresholdWhenLeaving?State.OCCUPIED_SEAT:State.EMPTY_SEAT;
            case FLOOR -> State.FLOOR;
            case EMPTY_SEAT -> numberOfAdjacentOccupiedSeats==0?State.OCCUPIED_SEAT:State.EMPTY_SEAT;
        };
    }
}
