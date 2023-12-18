package fpc.aoc.day18;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.day18.model.InstructionParser;
import fpc.aoc.day18.model.InstructionParserPart1;
import lombok.NonNull;

public class Day18Part1Solver extends Day18Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day18Part1Solver().createProblem();
  }

  @Override
  public InstructionParser getParser() {
    return new InstructionParserPart1();
  }
}
