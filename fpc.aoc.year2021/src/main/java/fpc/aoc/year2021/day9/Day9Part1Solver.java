package fpc.aoc.year2021.day9;

import fpc.aoc.api.Solver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Day9Part1Solver extends Day9Solver {

    public static @NonNull Solver provider() {
        return new Day9Part1Solver();
    }

    @Override
    public @NonNull Integer doSolve(@NonNull Map map) {
        return map.computePart1Result();
    }
}
