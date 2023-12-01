package fpc.aoc.day15;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day15Part2Solver extends Day15Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day15Part2Solver().createProblem();
    }

    @Override
    public boolean isSkipped() {
        return true;
    }

    @Override
    public @NonNull String solve(@NonNull Stream<String> input) {
        throw new NotSolvedYet();
    }
}
