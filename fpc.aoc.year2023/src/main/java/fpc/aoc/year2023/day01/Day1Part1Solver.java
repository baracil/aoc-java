package fpc.aoc.year2023.day01;

import fpc.aoc.api.Solver;

import java.util.function.ToIntFunction;

public class Day1Part1Solver extends Day1Solver {

  public static Solver provider() {
    return new Day1Part1Solver();
  }


  @Override
  protected ToIntFunction<String> getLineConverter() {
    return LineConverter.forPart1();
  }

}
