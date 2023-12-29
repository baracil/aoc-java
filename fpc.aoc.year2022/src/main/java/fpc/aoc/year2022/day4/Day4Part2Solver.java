package fpc.aoc.year2022.day4;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day4Part2Solver extends Day4Solver {

    public static @NonNull Solver provider() {
        return new Day4Part2Solver();
    }

    @Override
    public @NonNull Integer doSolve(@NonNull Stream<AssignmentPair> input) {
        return (int)input.filter(AssignmentPair::hasSectionsOverlapping).count();
    }
}
