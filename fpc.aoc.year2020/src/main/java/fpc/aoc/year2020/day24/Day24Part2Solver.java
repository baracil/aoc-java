package fpc.aoc.year2020.day24;

import fpc.aoc.api.Solver;
import fpc.aoc.common.CellState;
import fpc.aoc.common.GameOfLife;
import fpc.aoc.year2020.day24.structures.HexaPoint;
import fpc.aoc.year2020.day24.structures.Path;

import java.util.stream.Stream;

public class Day24Part2Solver extends Day24Solver {

  public static Solver provider() {
    return new Day24Part2Solver();
  }

  @Override
  public Integer doSolve(Stream<Path> input) {
    final var gameOfLife = GameOfLife.initialize(initialBlackTiles(input), this::rule);

    gameOfLife.performCycles(100);
    return gameOfLife.numberOfActiveCells();
  }

  private CellState rule(CellState previous, int nbNeighbour, HexaPoint position) {
    if (previous == CellState.ALIVE) {
      //black
      if (nbNeighbour == 0 || nbNeighbour > 2) {
        return CellState.DEAD;
      }
      return CellState.ALIVE;
    } else if (previous == CellState.DEAD && nbNeighbour == 2) {
      return CellState.ALIVE;
    }
    return previous;
  }
}
