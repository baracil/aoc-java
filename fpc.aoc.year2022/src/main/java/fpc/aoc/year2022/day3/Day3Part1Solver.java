package fpc.aoc.year2022.day3;

import fpc.aoc.api.Solver;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.stream.Stream;

public class Day3Part1Solver extends SmartSolver<Stream<Rucksack>> {

  public static Solver provider() {
    return new Day3Part1Solver();
  }

  @Override
  protected Converter<Stream<Rucksack>> getConverter() {
    return s -> s.stream().map(Rucksack::parse);
  }

  @Override
  public Integer doSolve(Stream<Rucksack> input) {
    return input.mapToInt(i -> i.findItemInBothCompartments() + 1).sum();
  }
}
