package fpc.aoc.year2020.day15;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day15Part2Solver extends Day15Solver {

    public static @NonNull Solver provider() {
        return new Day15Part2Solver();
    }

    @Override
    protected int getNumberOfTurns() {
        return 30_000_000;
    }
}
