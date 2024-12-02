package fpc.aoc.year2020.day2;


import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day2.structures.DatabaseEntry;

import java.util.function.Function;
import java.util.stream.Stream;

public class Day2Part2Solver extends Day2Solver {

  public static Solver provider() {
    return new Day2Part2Solver();
  }

  @Override
  protected Function<? super String, ? extends DatabaseEntry> getDatabaseEntryParser() {
    return DatabaseEntry::parseWithNewRule;
  }

  @Override
  public Long doSolve(Stream<DatabaseEntry> input) {
    return input.filter(DatabaseEntry::isEntryValid).count();
  }
}
