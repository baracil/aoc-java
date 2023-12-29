package fpc.aoc.year2022.day19;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day19Part2Solver extends Day19Solver {

    public static @NonNull Solver provider() {
        return new Day19Part2Solver();
    }


    @Override
    public @NonNull Long doSolve(@NonNull Stream<BluePrint> input) {
        return input
            .limit(3)
            .parallel()
            .mapToLong(this::compute)
            .reduce(1,(a,b) -> a*b);
    }

    private long compute(@NonNull BluePrint bluePrint) {
        return Factory.findBest(bluePrint,32).nbGeode();
    }

}
