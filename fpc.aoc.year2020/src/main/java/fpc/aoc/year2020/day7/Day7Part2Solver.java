package fpc.aoc.year2020.day7;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day7.structures.BagGraph;
import lombok.NonNull;

public class Day7Part2Solver extends Day7Solver {

    @Override
    public @NonNull Long doSolve(@NonNull BagGraph bagGraph) {
        return bagGraph.countContained("shiny gold");
    }

    public static @NonNull Solver provider() {
        return new Day7Part2Solver();
    }

}
