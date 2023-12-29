package fpc.aoc.year2023.day03;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day3Part2Solver extends Day3Solver {

    public static @NonNull Solver provider() {
        return new Day3Part2Solver();
    }

    @Override
    public @NonNull Object doSolve(@NonNull Schematic input) {
        return input.gearRatio().sum();
    }
}
