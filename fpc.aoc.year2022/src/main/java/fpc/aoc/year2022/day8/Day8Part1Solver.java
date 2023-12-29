package fpc.aoc.year2022.day8;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day8Part1Solver extends Day8Solver {

    public static @NonNull Solver provider() {
        return new Day8Part1Solver();
    }


    @Override
    public @NonNull Long doSolve(@NonNull Forest forest) {
        return forest.countNbVisibleTrees();
    }


}
