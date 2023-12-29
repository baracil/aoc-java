package fpc.aoc.year2022.day21;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day21Part1Solver extends Day21Solver<Long> {

    public static @NonNull Solver provider() {
        return new Day21Part1Solver();
    }

    public Day21Part1Solver() {
        super(new MonkeyEvaluatorPart1());
    }

    @Override
    protected Long finalize(Long rootResult) {
        return rootResult;
    }
}
