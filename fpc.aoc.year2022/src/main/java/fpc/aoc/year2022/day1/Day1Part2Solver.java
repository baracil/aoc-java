package fpc.aoc.year2022.day1;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Top;
import lombok.NonNull;

import java.util.stream.LongStream;

public class Day1Part2Solver extends Day1Solver {

    public static Solver provider() {
        return new Day1Part2Solver();
    }

    @Override
    public @NonNull Long doSolve(@NonNull LongStream input) {
        final var top = new Top(3);
        input.forEach(top::handle);
        return top.sum();
    }

}
