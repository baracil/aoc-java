package fpc.aoc.day4;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.List;

public class Day4Part1Solver extends Day4Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day4Part1Solver().createProblem();
    }

    @Override
    public @NonNull String solve(@NonNull List<Card> input) {
        return String.valueOf(input.stream().mapToInt(Card::score).sum());
    }
}
