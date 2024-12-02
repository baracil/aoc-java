package fpc.aoc.year2020.day14;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day14.structures.Memory;
import fpc.aoc.year2020.day14.structures.MemoryPart1;

public class Day14Part1Solver extends Day14Solver {

  public static Solver provider() {
    return new Day14Part1Solver();
  }

  @Override
  protected Memory createMemory() {
    return new MemoryPart1();
  }

}
