package fpc.aoc.day8;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day8Part1Solver extends Day8Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day8Part1Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull Input input) {
        return String.valueOf(input.part1());
    }
}
