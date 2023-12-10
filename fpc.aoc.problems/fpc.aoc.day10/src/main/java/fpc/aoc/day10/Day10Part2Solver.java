package fpc.aoc.day10;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

public class Day10Part2Solver extends Day10Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day10Part2Solver().createProblem();
    }


    @Override
    public @NonNull Integer solve(@NonNull Map input) {
        final var doubled = Doubled.create(input);
        doubled.fill();
        return doubled.countInside();
    }
}
