package fpc.aoc.year2021.day11;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day11Part1Solver extends Day11Solver {

    public static @NonNull Solver provider() {
        return new Day11Part1Solver();
    }

    @Override
    public @NonNull String doSolve(@NonNull Map map) {
        for (int i = 0; i < 100; i++) {
            map.executeOneStep();
        }
        return String.valueOf(map.numberOfFlashes());

    }
}
