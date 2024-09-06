package fpc.aoc.year2019.day15;

import fpc.aoc.api.Solver;
import fpc.aoc.year2019.day15.computation.DroidState;
import fpc.aoc.year2019.day15.computation.FindPath;
import lombok.NonNull;

public class Day15Part2Solver extends Day15Solver {

    public static Solver provider() {
        return new Day15Part2Solver();
    }


    @Override
    int solve(@NonNull DroidState state) {
        final var start = state.startPosition();
        final var oxygen = state.oxygenPosition();

        final var distance = FindPath.computeDistance(state.memory(), oxygen, start);


        return distance.values().stream().mapToInt(i ->i).max().orElseThrow();
    }
}
