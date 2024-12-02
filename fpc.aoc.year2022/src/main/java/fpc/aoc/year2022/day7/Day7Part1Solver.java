package fpc.aoc.year2022.day7;

import fpc.aoc.api.Solver;

public class Day7Part1Solver extends Day7Solver {

  public static Solver provider() {
    return new Day7Part1Solver();
  }

  @Override
  public Integer doSolve(FileSystem fileSystem) {

    return fileSystem.streamDirectories()
        .mapToInt(File.Folder::size)
        .filter(size -> size <= 100000)
        .sum();
  }
}
