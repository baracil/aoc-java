package fpc.aoc.year2022.day20;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day20Part2Solver extends Day20Solver {

    public static @NonNull Solver provider() {
        return new Day20Part2Solver();
    }

    public Day20Part2Solver() {
        super(811589153,10);
    }

}
