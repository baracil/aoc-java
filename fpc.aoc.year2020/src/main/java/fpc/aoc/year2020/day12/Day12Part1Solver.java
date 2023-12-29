package fpc.aoc.year2020.day12;

import fpc.aoc.api.Solver;
import fpc.aoc.common.Orientation;
import fpc.aoc.year2020.day12.structures.Executor;
import fpc.aoc.year2020.day12.structures.Ferry;
import fpc.aoc.year2020.day12.structures.Movement;
import fpc.aoc.year2020.day12.structures.Part1Executor;
import lombok.NonNull;

import java.util.List;

public class Day12Part1Solver extends Day12Solver {

    public static @NonNull Solver provider() {
        return new Day12Part1Solver();
    }

    @Override
    public @NonNull Integer doSolve(@NonNull List<Movement> movements) {
        final Ferry ferry = new Ferry(Orientation.E, 0, 0);
        final Executor ex = new Part1Executor(ferry);

        movements.forEach(ex::execute);


        return ferry.manhattanDistance();
    }

}
