package fpc.aoc.day15;

import fpc.aoc.api.AOCProblem;
import lombok.NonNull;

import java.util.List;

public class Day15Part1Solver extends Day15Solver {

    public static @NonNull AOCProblem<?> provider() {
        return new Day15Part1Solver().createProblem();
    }

    @Override
    public @NonNull Long solve(@NonNull List<String> input) {
        final var computer = new HashComputer();
        return input.stream().mapToLong(computer::compute).sum();
    }


}
