package fpc.aoc.day14;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.day14.model.Platform;
import lombok.NonNull;

public class Day14Part1Solver extends Day14Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day14Part1Solver().createProblem();
    }

    @Override
    public @NonNull Integer solve(@NonNull Platform input) {
        input.tileToNorth();
        return input.computeNorthWeight();
    }
}
