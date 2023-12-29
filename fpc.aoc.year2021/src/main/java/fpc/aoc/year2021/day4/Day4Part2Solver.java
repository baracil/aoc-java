package fpc.aoc.year2021.day4;

import fpc.aoc.api.Solver;
import fpc.aoc.common.AOCException;
import fpc.aoc.year2021.day4.struct.Day04Input;
import fpc.aoc.year2021.day4.struct.GridState;
import lombok.NonNull;

public class Day4Part2Solver extends Day4Solver {

    public static @NonNull Solver provider() {
        return new Day4Part2Solver();
    }

    @Override
    public @NonNull String doSolve(@NonNull Day04Input input) {
        Day04Input current = input;
        do {
            final var newInput = current.playOneRoundPart2().orElse(null);
            if (newInput == null) {
                return switch (current.gridState()) {
                    case GridState.Winning winning -> String.valueOf(winning.score());
                    case GridState.NotWinning ignored -> throw new AOCException("Cannot solve the problem");
                };
            }
            current = newInput;
        } while (true);
    }
}
