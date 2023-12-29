package fpc.aoc.year2020.day19;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day19.structures.Day19Input;
import lombok.NonNull;

public class Day19Part1Solver extends Day19Solver {

    public static @NonNull Solver provider() {
        return new Day19Part1Solver();
    }

    @Override
    protected @NonNull Day19Input modifyInput(@NonNull Day19Input input) {
        return input;
    }
}
