package fpc.aoc.year2022.day22;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day22Part2Solver extends Day22Solver {

    public static @NonNull Solver provider() {
        return new Day22Part2Solver();
    }

    public Day22Part2Solver() {
        super(NavigationFactory.part2());
    }
}
