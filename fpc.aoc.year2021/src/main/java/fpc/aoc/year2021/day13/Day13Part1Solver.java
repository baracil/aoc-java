package fpc.aoc.year2021.day13;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day13.struct.Input;
import lombok.NonNull;

public class Day13Part1Solver extends Day13Solver {

    public static @NonNull Solver provider() {
        return new Day13Part1Solver();
    }

    @Override
    public @NonNull String doSolve(@NonNull Input input) {
        final var fold = input.folds().getFirst();

        final var sheet = input.sheet().fold(fold);

        return String.valueOf(sheet.getNumberOfDots());
    }
}
