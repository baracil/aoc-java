package fpc.aoc.day7;

import fpc.aoc.api.AOCProblem;
import fpc.aoc.day7.model.HandParser;
import lombok.NonNull;

public class Day7Part1Solver extends Day7Solver {

  public static @NonNull AOCProblem<?> provider() {
    return new Day7Part1Solver().createProblem();
  }

  @Override
  protected HandParser createHandParser() {
    return HandParser.forPart1();
  }
}
