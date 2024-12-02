package fpc.aoc.year2020.day2;


import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day2.structures.DatabaseEntry;

import java.util.function.Function;
import java.util.stream.Stream;

public abstract class Day2Solver extends SmartSolver<Stream<DatabaseEntry>> {

  protected abstract Function<? super String, ? extends DatabaseEntry> getDatabaseEntryParser();

  @Override
  protected Converter<Stream<DatabaseEntry>> getConverter() {
    return s -> s.stream().map(getDatabaseEntryParser());
  }
}
