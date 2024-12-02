package fpc.aoc.year2022.day10;

import fpc.aoc.api.Solver;

import java.util.List;

public class Day10Part2Solver extends Day10Solver {

  public static Solver provider() {
    return new Day10Part2Solver();
  }

  @Override
  public String doSolve(List<Command> input) {
    final var videoSystem = new VideoSystem();

    videoSystem.execute(new CommandProvider(input));
    return videoSystem.dumpDisplay();
  }
}
