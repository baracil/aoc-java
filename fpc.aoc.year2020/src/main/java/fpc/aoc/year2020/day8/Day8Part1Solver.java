package fpc.aoc.year2020.day8;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day8.structures.Processor;
import fpc.aoc.year2020.day8.structures.Program;

public class Day8Part1Solver extends Day8Solver {

  public static Solver provider() {
    return new Day8Part1Solver();
  }

  @Override
  public Integer doSolve(Program program) {
    return Processor.with(new Part1StopCondition())
        .launch(program)
        .getResultOrThrow()
        .accumulator();
  }
}
