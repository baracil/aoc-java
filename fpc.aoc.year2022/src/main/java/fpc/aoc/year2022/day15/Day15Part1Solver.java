package fpc.aoc.year2022.day15;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day15Part1Solver extends Day15Solver {

    public static @NonNull Solver provider() {
        return new Day15Part1Solver();
    }

    private final int lineNumber;

    public Day15Part1Solver(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Day15Part1Solver() {
        lineNumber = 2000000;
    }

    @Override
    public @NonNull Long doSolve(@NonNull Report input) {
        return input.computePart1(lineNumber);
    }
}
