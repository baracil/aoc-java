package fpc.aoc.year2024.day04;

import fpc.aoc.api.Solver;
import fpc.aoc.common.ArrayOfChar;
import fpc.aoc.common.Position;
import fpc.aoc.common.Translation;

import java.util.List;

import static fpc.aoc.common.Displacement.*;

public class Day4Part2Solver extends Day4Solver {

  public static Solver provider() {
    return new Day4Part2Solver();
  }

  private static final List<Translation> CORNERS = List.of(NW, NE, SE, SW);

  @Override
  protected long countFrom(ArrayOfChar input, Position position) {
    if (input.get(position) != 'A') {
      return 0;
    }
    String reduce = CORNERS.stream().map(position::displaced)
        .map(input::get)
        .reduce("", (s, c) -> s + c, (s1, s2) -> s1 + s2);

    return switch (reduce) {
      case "MMSS", "MSSM", "SSMM", "SMMS" -> 1;
      default -> 0;
    };
  }

}
