package fpc.aoc.year2019.day13;

import fpc.aoc.api.Solver;
import fpc.aoc.computer.Program;
import fpc.aoc.computer.ProgramBasedSolver;
import fpc.aoc.computer.io.ProgramIO;
import fpc.aoc.year2019.day13._private.GameOutput;
import fpc.aoc.year2019.day13._private.OutputListener;
import fpc.aoc.year2019.day13._private.Tile;
import fpc.aoc.year2019.day13._private.TileType;

public class Day13Part1Solver extends ProgramBasedSolver {

  public static Solver provider() {
    return new Day13Part1Solver();
  }


  @Override
  protected String doSolve(Program program) {
    final Listener listener = new Listener();
    final GameOutput gameOutput = new GameOutput(listener);
    program.launchAndWait("Game", ProgramIO.noInput().consumeWith(gameOutput::write));
    return listener.nbBlocks + "";
  }

  private static class Listener implements OutputListener {

    private int nbBlocks;

    @Override
    public void onTile(Tile tile) {
      if (tile.type() == TileType.BLOCK) {
        nbBlocks++;
      }
    }

    @Override
    public void onScore(String score) {
    }
  }

}
