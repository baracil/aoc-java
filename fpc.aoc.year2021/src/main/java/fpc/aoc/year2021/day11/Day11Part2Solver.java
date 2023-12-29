package fpc.aoc.year2021.day11;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day11Part2Solver extends Day11Solver {

    public static @NonNull Solver provider() {
        return new Day11Part2Solver();
    }

    @Override
    public @NonNull String doSolve(@NonNull Map map) {
        int step = 0;
        do {
            step +=1;
            if (map.executeOneStep()) {
                return String.valueOf(step);
            }
        } while (true);


    }
}
