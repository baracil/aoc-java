package fpc.aoc.year2022.day7;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day7Part1Solver extends Day7Solver {

    public static @NonNull Solver provider() {
        return new Day7Part1Solver();
    }

    @Override
    public @NonNull Integer doSolve(@NonNull FileSystem fileSystem) {

        return fileSystem.streamDirectories()
            .mapToInt(File.Folder::size)
            .filter(size -> size <= 100000)
            .sum();
    }
}
