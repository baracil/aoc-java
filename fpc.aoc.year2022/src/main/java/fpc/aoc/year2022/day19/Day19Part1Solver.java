package fpc.aoc.year2022.day19;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day19Part1Solver extends Day19Solver {

    public static @NonNull Solver provider() {
        return new Day19Part1Solver();
    }


    @Override
    public @NonNull Long doSolve(@NonNull Stream<BluePrint> input) {
        return input
            .parallel()
            .mapToLong(this::compute)
            .sum();
    }

    private long compute(@NonNull BluePrint bluePrint) {
        return Factory.findBest(bluePrint,24).getQualityLevel();
    }

}
