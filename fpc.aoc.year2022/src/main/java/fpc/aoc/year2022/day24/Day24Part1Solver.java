package fpc.aoc.year2022.day24;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day24Part1Solver extends Day24Solver {

    public static @NonNull Solver provider() {
        return new Day24Part1Solver();
    }

    @Override
    public @NonNull Integer doSolve(@NonNull Map input) {
        final var path = PathFinder.findPathPart1(input);
        return path.turn();
    }
}
