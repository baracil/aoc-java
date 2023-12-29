package fpc.aoc.year2022.day10;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.List;

public abstract class Day10Solver<T> extends SmartSolver<List<Command>> {

  @Override
  protected @NonNull Converter<List<Command>> getConverter() {
    return Converter.forItem(Command::parse);
  }
}
