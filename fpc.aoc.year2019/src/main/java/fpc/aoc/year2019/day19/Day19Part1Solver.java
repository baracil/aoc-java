package fpc.aoc.year2019.day19;

import fpc.aoc.api.Solver;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import fpc.aoc.year2019.day19._private.BeamSizeProbe;

public class Day19Part1Solver extends ProgramBasedSolver {

  public static Solver provider() {
    return new Day19Part1Solver();
  }


  @Override
  protected Object doSolve(Program program) {
    return BeamSizeProbe.probe(program);
  }

}
