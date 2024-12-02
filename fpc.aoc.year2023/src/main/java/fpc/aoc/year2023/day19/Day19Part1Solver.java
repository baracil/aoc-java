package fpc.aoc.year2023.day19;

import fpc.aoc.api.Solver;
import fpc.aoc.year2023.day19.model.Input;
import fpc.aoc.year2023.day19.model.Scrap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day19Part1Solver extends Day19Solver {

  public static Solver provider() {
    return new Day19Part1Solver();
  }

  @Override
  public Object doSolve(Input input) {
    final Map<String, List<Scrap>> result = new HashMap<>();


    for (Scrap scrap : input.scraps()) {
      final var w = input.process(scrap);
      result.computeIfAbsent(w, i -> new ArrayList<>()).add(scrap);
    }

    return (long) result.get("A").stream().mapToInt(Scrap::rating).sum();
  }
}
