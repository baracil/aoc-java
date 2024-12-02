package fpc.aoc.year2020.day7;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day7.structures.BagGraph;

public class Day7Part1Solver extends Day7Solver {

  @Override
  public Long doSolve(BagGraph bagGraph) {
    return bagGraph.countContainers("shiny gold");
  }

  public static Solver provider() {
    return new Day7Part1Solver();
  }

}
