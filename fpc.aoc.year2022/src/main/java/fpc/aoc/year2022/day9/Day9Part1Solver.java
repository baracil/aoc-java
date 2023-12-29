package fpc.aoc.year2022.day9;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day9Part1Solver extends Day9Solver {

    public static @NonNull Solver provider() {
        return new Day9Part1Solver();
    }

    public Day9Part1Solver() {
        super(2);
    }
}
