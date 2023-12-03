package fpc.aoc.day3;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day3Part2Solver extends Day3Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day3Part2Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Schematic input) {
        return input.gearRatio().sum();
    }
}
