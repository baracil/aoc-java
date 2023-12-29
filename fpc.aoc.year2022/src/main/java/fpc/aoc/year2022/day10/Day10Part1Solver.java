package fpc.aoc.year2022.day10;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.List;
import java.util.stream.IntStream;

public class Day10Part1Solver extends Day10Solver<Integer> {

    public static @NonNull Solver provider() {
        return new Day10Part1Solver();
    }


    @Override
    public @NonNull Integer doSolve(@NonNull List<Command> input) {
        final var videoSystem = new VideoSystem();

        videoSystem.execute(new CommandProvider(input));

        return IntStream.iterate(20, i -> i <= 220, i -> i + 40)
            .map(videoSystem.signalStrength()::get)
            .sum();

    }
}
