package fpc.aoc.year2019.day5;

import fpc.aoc.api.Solver;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import fpc.aoc.computer.io.ProgramIO;
import lombok.NonNull;

public class Day5Part1Solver extends ProgramBasedSolver {

  public static Solver provider() {
    return new Day5Part1Solver();
  }

  @Override
  protected String doSolve(@NonNull Program program) {
    return program.launchAndWait("Day5 Part 1", ProgramIO.fromList("1").ignoreOutput()).getLastOutput();
  }

}
