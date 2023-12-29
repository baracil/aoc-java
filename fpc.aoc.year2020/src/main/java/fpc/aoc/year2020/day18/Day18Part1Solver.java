package fpc.aoc.year2020.day18;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day18.structures.ExpressionEvaluator;
import fpc.aoc.year2020.day18.structures.ExpressionEvaluatorPart1;
import lombok.NonNull;

public class Day18Part1Solver extends Day18Solver {

    public static @NonNull Solver provider() {
        return new Day18Part1Solver();
    }

    @Override
    protected @NonNull ExpressionEvaluator createOnePassEvaluator() {
        return new ExpressionEvaluatorPart1();
    }
}
