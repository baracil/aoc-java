package fpc.aoc.year2022.day7;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

public abstract class Day7Solver extends SmartSolver<FileSystem> {

  @Override
  protected Converter<FileSystem> getConverter() {
    return input -> input.stream().collect(FileSystemCollector.COLLECTOR);
  }
}
