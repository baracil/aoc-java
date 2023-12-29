package fpc.aoc.year2022.day12;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day12Part1Solver extends Day12Solver {

    public static @NonNull Solver provider() {
        return new Day12Part1Solver();
    }

    public Day12Part1Solver() {
        super(new Part1PathInfo());
    }
}
