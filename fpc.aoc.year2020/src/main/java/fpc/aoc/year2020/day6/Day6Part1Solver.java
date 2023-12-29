package fpc.aoc.year2020.day6;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day6.structures.Group;
import lombok.NonNull;

import java.util.List;

public class Day6Part1Solver extends Day6Solver {

    public static @NonNull Solver provider() {
        return new Day6Part1Solver();
    }

    @Override
    public @NonNull Integer doSolve(@NonNull List<Group> input) {
        return input.stream()
             .mapToInt(Group::getNumberOfDistinctQuestions)
             .sum();
    }
}
