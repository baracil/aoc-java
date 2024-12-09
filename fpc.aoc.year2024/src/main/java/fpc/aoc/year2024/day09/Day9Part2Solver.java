package fpc.aoc.year2024.day09;

import fpc.aoc.api.Solver;

public class Day9Part2Solver extends Day9Solver {

  public static Solver provider() {
    return new Day9Part2Solver();
  }

  @Override
  protected Object doSolve(Disk disk) {
    disk.compactPart2();
    return disk.computeChecksum();
  }
}
