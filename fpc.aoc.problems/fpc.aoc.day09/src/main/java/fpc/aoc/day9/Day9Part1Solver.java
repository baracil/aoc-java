package fpc.aoc.day9;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day9Part1Solver extends Day9Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day9Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull Stream<long[]> input) {
        return input.mapToLong(Extrapoler::computePart1).sum();
    }
}
