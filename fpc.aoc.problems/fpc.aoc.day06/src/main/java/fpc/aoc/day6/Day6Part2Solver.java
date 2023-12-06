package fpc.aoc.day6;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.List;

public class Day6Part2Solver extends Day6Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day6Part2Solver().createProblem();
    }


    @Override
    public @NonNull Long solve(@NonNull List<String> input) {
        return Race.parsePart2(input).nbWins();
    }
}
