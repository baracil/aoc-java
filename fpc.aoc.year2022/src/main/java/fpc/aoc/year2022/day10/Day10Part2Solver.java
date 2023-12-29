package fpc.aoc.year2022.day10;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.List;

public class Day10Part2Solver extends Day10Solver<String> {

    public static @NonNull Solver provider() {
        return new Day10Part2Solver();
    }

    @Override
    public @NonNull String doSolve(@NonNull List<Command> input) {
        final var videoSystem = new VideoSystem();

        videoSystem.execute(new CommandProvider(input));
        return videoSystem.dumpDisplay();
    }
}
