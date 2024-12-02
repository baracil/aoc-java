package fpc.aoc.year2020.day10;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day10.structures.LinearCounter;
import fpc.aoc.year2020.day10.structures.Part2Counter;
import fpc.aoc.year2020.day10.structures.RecursiveCounter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Day10Part2Solver extends Day10Solver {

  public static Solver provider() {
    return new Day10Part2Solver();
  }

  public final boolean useLinear;

  public Day10Part2Solver() {
    this(true);
  }

  @Override
  public Long doSolve(int[] input) {
    final Part2Counter counter = useLinear ? new LinearCounter() : new RecursiveCounter();
    return counter.count(input);
  }

}




