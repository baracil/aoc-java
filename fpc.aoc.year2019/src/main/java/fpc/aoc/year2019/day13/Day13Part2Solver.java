package fpc.aoc.year2019.day13;

import fpc.aoc.api.Solver;
import fpc.aoc.computer.Alterations;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import fpc.aoc.computer.io.ProgramIO;
import fpc.aoc.year2019.day13._private.GameIO;

public class Day13Part2Solver extends ProgramBasedSolver {

  public static Solver provider() {
    return new Day13Part2Solver();
  }

  @Override
  protected String doSolve(Program program) {
    final Alterations alterations = Alterations.with(0, "2");
    final GameIO gameIO = new GameIO();
    program.launchAndWait("Game", ProgramIO.withSupplier(gameIO::read).consumeWith(gameIO::write), alterations);

    return gameIO.score();
  }

}
