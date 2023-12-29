package fpc.aoc.year2020.day2;


import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day2.structures.DatabaseEntry;
import lombok.NonNull;

import java.util.function.Function;
import java.util.stream.Stream;

public class Day2Part1Solver extends Day2Solver {

    public static @NonNull Solver provider() {
        return new Day2Part1Solver();
    }


    @Override
    protected Function<? super String, ? extends DatabaseEntry> getDatabaseEntryParser() {
        return DatabaseEntry::parseWithOldRule;
    }

    @Override
    public @NonNull Long doSolve(@NonNull Stream<DatabaseEntry> input) {
        return input.filter(DatabaseEntry::isEntryValid).count();
    }

}
