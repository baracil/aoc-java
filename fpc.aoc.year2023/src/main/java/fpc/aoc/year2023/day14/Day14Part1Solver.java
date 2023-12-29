package fpc.aoc.year2023.day14;

import fpc.aoc.api.Solver;
import fpc.aoc.year2023.day14.model.Platform;
import lombok.NonNull;

public class Day14Part1Solver extends Day14Solver {

    public static @NonNull Solver provider() {
        return new Day14Part1Solver();
    }

    @Override
    public @NonNull Object doSolve(@NonNull Platform input) {
        input.tileToNorth();
        return input.computeNorthWeight();
    }
}
