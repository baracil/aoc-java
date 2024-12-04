package fpc.aoc.year2024.day04;

import fpc.aoc.api.Solver;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Displacement;
import fpc.aoc.common.Position;

import java.util.List;

import static fpc.aoc.common.Displacement.*;

public class Day4Part1Solver extends Day4Solver {

  public static Solver provider() {
    return new Day4Part1Solver();
  }


  public final List<Displacement> ALL_DISPLACEMENTS = List.of(N, E, S, W, NE, NW, SE, SW);
  private static final char[] XMAS = {'X', 'M', 'A', 'S'};

  @Override
  protected long countFrom(ArrayOfChar input, Position position) {
    return ALL_DISPLACEMENTS.stream()
        .filter(d -> match(input, position, d))
        .count();
  }

  protected boolean match(ArrayOfChar input, Position position, Displacement displacement) {
    Position current = position;
    for (char xma : XMAS) {
      if (input.get(current) != xma) {
        return false;
      }
      current = current.displaced(displacement);
    }
    return true;
  }

}
