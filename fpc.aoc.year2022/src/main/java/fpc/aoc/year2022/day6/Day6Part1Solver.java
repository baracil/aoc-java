package fpc.aoc.year2022.day6;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day6Part1Solver extends Day6Solver {

    public static @NonNull Solver provider() {
        return new Day6Part1Solver();
    }


    public Day6Part1Solver() {
        super(4);
    }
}
