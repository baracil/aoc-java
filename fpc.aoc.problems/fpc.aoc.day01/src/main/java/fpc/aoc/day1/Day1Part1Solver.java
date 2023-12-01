package fpc.aoc.day1;

import fpc.aoc.api.AOCProblem;

import java.util.function.ToIntFunction;

public class Day1Part1Solver extends Day1Solver {

  public static AOCProblem<?> provider() {
    return new Day1Part1Solver().createProblem();
  }


  @Override
  protected ToIntFunction<String> getLineConverter() {
    return LineConverter.forPart1();
  }

}
