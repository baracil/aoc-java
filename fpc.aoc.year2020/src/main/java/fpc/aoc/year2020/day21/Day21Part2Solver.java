package fpc.aoc.year2020.day21;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day21.structures.Guide;
import fpc.aoc.year2020.day21.structures.Ingredient;
import lombok.NonNull;

import java.util.Map;
import java.util.stream.Collectors;

public class Day21Part2Solver extends Day21Solver {

  public static @NonNull Solver provider() {
    return new Day21Part2Solver();
  }

  @Override
  public @NonNull String doSolve(@NonNull Guide guide) {
    return guide.allergenIdentification()
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .map(Map.Entry::getValue)
        .map(Ingredient::name)
        .collect(Collectors.joining(","));
  }
}
