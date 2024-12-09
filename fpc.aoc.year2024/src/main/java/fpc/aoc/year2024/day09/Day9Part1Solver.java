package fpc.aoc.year2024.day09;

import fpc.aoc.api.Solver;

public class Day9Part1Solver extends Day9Solver {

  public static Solver provider() {
    return new Day9Part1Solver();
  }

  @Override
  protected Object doSolve(Disk disk) {
    disk.compactPart1();
    return disk.computeChecksum();
  }
}
