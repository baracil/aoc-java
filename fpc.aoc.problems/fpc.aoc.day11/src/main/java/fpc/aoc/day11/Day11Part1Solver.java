package fpc.aoc.day11;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.NotSolvedYet;
import lombok.NonNull;

import java.util.Arrays;
import java.util.stream.Stream;

public class Day11Part1Solver extends Day11Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day11Part1Solver().createProblem();
    }


    @Override
    public @NonNull Long solve(@NonNull ArrayOfChar input) {
        return Part1.find(input);
    }
}
