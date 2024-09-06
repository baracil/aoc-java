package fpc.aoc.year2019.day1;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.stream.IntStream;

public class Day1Part1Solver extends Day1Solver {

  public static Solver provider() {
    return new Day1Part1Solver();
  }

  @Override
  protected @NonNull Object doSolve(@NonNull IntStream input) {
    return input.map(FuelRequirement::basicFuelRequirement).sum();
  }

}
