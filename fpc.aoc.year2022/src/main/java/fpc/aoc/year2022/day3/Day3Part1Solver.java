package fpc.aoc.year2022.day3;

import fpc.aoc.api.Solver;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public class Day3Part1Solver extends SmartSolver<Stream<Rucksack>> {

    public static @NonNull Solver provider() {
        return new Day3Part1Solver();
    }

    @Override
    protected @NonNull Converter<Stream<Rucksack>> getConverter() {
        return s -> s.stream().map(Rucksack::parse);
    }

    @Override
    public @NonNull Integer doSolve(@NonNull Stream<Rucksack> input) {
        return input.mapToInt(i -> i.findItemInBothCompartments() + 1).sum();
    }
}
