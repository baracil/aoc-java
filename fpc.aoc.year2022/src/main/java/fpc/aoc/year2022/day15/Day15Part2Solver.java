package fpc.aoc.year2022.day15;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day15Part2Solver extends Day15Solver {

    public static @NonNull Solver provider() {
        return new Day15Part2Solver();
    }

    private final int sup;

    public Day15Part2Solver(int sup) {
        this.sup = sup;
    }

    public Day15Part2Solver() {
        this.sup = 4_000_000;
    }

    @Override
    public @NonNull Long doSolve(@NonNull Report report) {
        return report.computePart2(sup);
    }
}
