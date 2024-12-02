package fpc.aoc.year2019.day9;

import fpc.aoc.api.Solver;
import fpc.aoc.common.AOCException;
import fpc.aoc.common.Nil;
import fpc.aoc.computer.Execution;
import fpc.aoc.computer.ExecutionResult;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import fpc.aoc.computer.io.ProgramIO;

public class Day9Part2Solver extends ProgramBasedSolver {

  public static Solver provider() {
    return new Day9Part2Solver();
  }

  @Override
  protected String doSolve(Program program) {
    final Execution<Nil, Nil> execution = program.launch(id().toString(), ProgramIO.fromList("2").ignoreOutput());

    final ExecutionResult result = execution.waitTermination();

    if (result.numberOfOutput() != 1) {
      System.out.println("Opcode error :");
      result.forEachOutput(System.out::println);
      throw new AOCException("Invalid IntComputer");
    } else {
      return result.getLastOutput();
    }
  }
}
