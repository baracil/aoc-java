package fpc.aoc.year2020.day19;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day19.structures.Day19Input;
import fpc.aoc.year2020.day19.structures.Or;
import lombok.NonNull;

import java.util.Map;

import static fpc.aoc.year2020.day19.structures.Concatenation.concatenation;
import static fpc.aoc.year2020.day19.structures.Or.or;

public class Day19Part2Solver extends Day19Solver {

  public static @NonNull Solver provider() {
    return new Day19Part2Solver();
  }

  @Override
  protected @NonNull Day19Input modifyInput(@NonNull Day19Input input) {
    final Or newRule8 = or(concatenation(42), concatenation(42, 8));
    final Or newRule11 = or(concatenation(42, 31), concatenation(42, 11, 31));
    return input.replaceRules(Map.of(8, newRule8, 11, newRule11));
  }
}
