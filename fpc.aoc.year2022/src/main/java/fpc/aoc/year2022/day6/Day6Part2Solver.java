package fpc.aoc.year2022.day6;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day6Part2Solver extends Day6Solver {

    public static @NonNull Solver provider() {
        return new Day6Part2Solver();
    }

    public Day6Part2Solver() {
        super(14);
    }
}
