package fpc.aoc.year2015.day13;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.List;

public class Day13Part1Solver extends Day13Solver {

  public static @NonNull Solver provider() {
    return new Day13Part1Solver();
  }

  @Override
  protected List<Link> prepare(List<Link> links) {
    return links;
  }
}
