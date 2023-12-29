package fpc.aoc.year2021.day8;

import fpc.aoc.api.Solver;
import fpc.aoc.year2021.day8.struct.WiringInfo;
import lombok.NonNull;

import java.util.Collection;
import java.util.stream.Stream;

public class Day8Part1Solver extends Day8Solver {

    public static @NonNull Solver provider() {
        return new Day8Part1Solver();
    }

    @Override
    public @NonNull Long doSolve(@NonNull Stream<WiringInfo<String>> input) {
        return input.map(WiringInfo::digits)
                    .flatMap(Collection::stream)
                    .map(String::length)
                    .filter(l -> l == 2 || l == 3 || l == 4 || l == 7)
                    .count();
    }
}
