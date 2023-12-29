package fpc.aoc.year2021.day13;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day13.struct.Input;
import fpc.aoc.year2021.day13.struct.Sheet;
import lombok.NonNull;

public class Day13Part2Solver extends Day13Solver {

    public static @NonNull Solver provider() {
        return new Day13Part2Solver();
    }

    @Override
    public @NonNull String doSolve(@NonNull Input input) {
        final var sheet = input.folds()
                               .stream()
                               .reduce(input.sheet(), Sheet::fold,(s1, s2) -> {throw new UnsupportedOperationException();});

        return sheet.toDisplay();
    }

}
