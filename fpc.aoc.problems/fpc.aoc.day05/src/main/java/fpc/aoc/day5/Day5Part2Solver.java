package fpc.aoc.day5;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.NotSolvedYet;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day5Part2Solver extends Day5Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day5Part2Solver().createProblem();
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
