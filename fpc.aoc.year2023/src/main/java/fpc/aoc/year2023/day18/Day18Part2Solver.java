package fpc.aoc.year2023.day18;

import fpc.aoc.api.Solver;
import fpc.aoc.year2023.day18.model.InstructionParser;
import fpc.aoc.year2023.day18.model.InstructionParserPart2;

public class Day18Part2Solver extends Day18Solver {

  public static Solver provider() {
    return new Day18Part2Solver();
  }

  @Override
  public InstructionParser getParser() {
    return new InstructionParserPart2();
  }
}
