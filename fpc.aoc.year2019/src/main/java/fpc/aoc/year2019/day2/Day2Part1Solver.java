package fpc.aoc.year2019.day2;


import fpc.aoc.api.Solver;
import fpc.aoc.computer.Alterations;
import fpc.aoc.computer.ExecutionResult;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import lombok.NonNull;

public class Day2Part1Solver extends ProgramBasedSolver {

  public static @NonNull Solver provider() {
    return new Day2Part1Solver();
  }

  @Override
  protected Object doSolve(Program program) {
    final Alterations alterations = Alterations.none().addAlterations(1, "12", "2");
    final ExecutionResult result = program.launchAndWait("Day2 Part1", alterations);
    return result.getFirstValueOfMemory();

  }


}
