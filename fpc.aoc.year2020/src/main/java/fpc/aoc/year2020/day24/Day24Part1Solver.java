package fpc.aoc.year2020.day24;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day24.structures.Path;

import java.util.stream.Stream;

public class Day24Part1Solver extends Day24Solver {

  public static Solver provider() {
    return new Day24Part1Solver();
  }

  @Override
  public Integer doSolve(Stream<Path> input) {
    return initialBlackTiles(input).size();
  }
}
