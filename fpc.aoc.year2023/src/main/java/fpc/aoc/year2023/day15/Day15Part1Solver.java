package fpc.aoc.year2023.day15;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.List;

public class Day15Part1Solver extends Day15Solver {

    public static @NonNull Solver provider() {
        return new Day15Part1Solver();
    }

    @Override
    public @NonNull Object doSolve(@NonNull List<String> input) {
        final var computer = new HashComputer();
        return input.stream().mapToLong(computer::compute).sum();
    }


}
