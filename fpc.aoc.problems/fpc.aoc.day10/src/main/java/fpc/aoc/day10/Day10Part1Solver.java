package fpc.aoc.day10;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day10Part1Solver extends Day10Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day10Part1Solver().createProblem();
    }


    @Override
    public @NonNull Integer solve(@NonNull Map input) {
        final var cycle = input.cycle();
        return cycle.size()/2;
    }
}
