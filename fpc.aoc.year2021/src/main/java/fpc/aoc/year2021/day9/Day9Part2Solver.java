package fpc.aoc.year2021.day9;

import fpc.aoc.api.Solver;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Day9Part2Solver extends Day9Solver {

    public static @NonNull Solver provider() {
        return new Day9Part2Solver();
    }


    @Override
    public @NonNull Integer doSolve(@NonNull Map map) {
        return map.computePart2Result();
    }
}
