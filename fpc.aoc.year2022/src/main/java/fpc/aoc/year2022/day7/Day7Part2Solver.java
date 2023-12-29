package fpc.aoc.year2022.day7;

import fpc.aoc.api.Solver;
import fpc.aoc.common.AOCException;
import lombok.NonNull;

import java.util.Comparator;

public class Day7Part2Solver extends Day7Solver {

  public static @NonNull Solver provider() {
    return new Day7Part2Solver();
  }

  @Override
  public @NonNull Integer doSolve(@NonNull FileSystem fileSystem) {
    final var freeSpace = fileSystem.getFreeSpace();
    final var missingSpace = 30_000_000 - freeSpace;

    final var folderToSuppress = fileSystem.streamDirectories()
        .filter(folder -> folder.size() > missingSpace)
        .min(Comparator.comparing(File.Folder::size))
        .orElseThrow(() -> new AOCException("Too stupid to solve this problem"));

    return folderToSuppress.size();
  }
}
