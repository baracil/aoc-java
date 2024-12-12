package fpc.aoc.year2024.day12;

import fpc.aoc.api.Solver;

import java.util.Map;

public class Day12Part1Solver extends Day12Solver {

  public static Solver provider() {
    return new Day12Part1Solver();
  }

  @Override
  protected Object doSolve(Field field) {
    Map<Character, Plots> plots = field.findPlots();
    return plots.values().stream().mapToInt(Plots::getPricePart1).sum();
  }
}
