package fpc.aoc.year2019.day18;

import fpc.aoc.api.Solver;
import fpc.aoc.year2019.day18._private.Maze;

import java.util.stream.Collector;

public class Day18Part2Solver extends Day18Solver {

  public static Solver provider() {
    return new Day18Part2Solver();
  }

  @Override
  protected Collector<String, ?, Maze> getMazeCollector() {
    return Maze.collector(true);
  }
}
