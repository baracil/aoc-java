package fpc.aoc.year2022.day24;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day24Part2Solver extends Day24Solver {

    public static @NonNull Solver provider() {
        return new Day24Part2Solver();
    }



    @Override
    public @NonNull Object doSolve(@NonNull Map input) {
        return PathFinder.findPathPart2(input).turn();
    }
}
