package fpc.aoc.year2021.day4;

import fpc.aoc.api.Solver;
import fpc.aoc.common.AOCException;
import fpc.aoc.year2021.day4.struct.Day04Input;
import fpc.aoc.year2021.day4.struct.GridState;

public class Day4Part1Solver extends Day4Solver {

  public static Solver provider() {
    return new Day4Part1Solver();
  }

  @Override
  public String doSolve(Day04Input input) {
    Day04Input current = input;
    do {
      final var newState = current.playOneRoundPart1().orElse(null);
      if (newState == null) {
        throw new AOCException("Cannot solve the problem");
      }
      if (newState.gridState() instanceof GridState.Winning winning) {
        return String.valueOf(winning.score());
      }
      current = newState;
    } while (true);
  }
}
