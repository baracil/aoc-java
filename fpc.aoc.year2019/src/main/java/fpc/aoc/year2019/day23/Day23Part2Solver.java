package fpc.aoc.year2019.day23;

import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import fpc.aoc.year2019.day23._private.NetworkWithNAT;
import lombok.NonNull;

/**
 * @author Bastien Aracil
 **/
public class Day23Part2Solver extends ProgramBasedSolver {

  @Override
  protected String doSolve(@NonNull Program program) {
    return new NetworkWithNAT(program).waitForResult();
  }
}
