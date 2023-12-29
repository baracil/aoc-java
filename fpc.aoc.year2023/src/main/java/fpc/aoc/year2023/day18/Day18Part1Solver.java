package fpc.aoc.year2023.day18;

import fpc.aoc.api.Solver;
import fpc.aoc.year2023.day18.model.InstructionParser;
import fpc.aoc.year2023.day18.model.InstructionParserPart1;
import lombok.NonNull;

public class Day18Part1Solver extends Day18Solver {

  public static @NonNull Solver provider() {
    return new Day18Part1Solver();
  }

  @Override
  public InstructionParser getParser() {
    return new InstructionParserPart1();
  }
}
