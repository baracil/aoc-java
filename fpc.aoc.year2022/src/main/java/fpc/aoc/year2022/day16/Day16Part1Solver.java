package fpc.aoc.year2022.day16;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day16Part1Solver extends Day16Solver {

    public static @NonNull Solver provider() {
        return new Day16Part1Solver();
    }

    @Override
    public @NonNull Long doSolve(@NonNull Valves input) {
        return new ValveSolver(input).doSolve(0,30);
    }
}
