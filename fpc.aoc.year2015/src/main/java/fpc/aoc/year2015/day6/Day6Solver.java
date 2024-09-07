package fpc.aoc.year2015.day6;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.List;

public abstract class Day6Solver extends SmartSolver<List<Command>> {

  @Override
  protected @NonNull Converter<List<Command>> getConverter() {
    return Converter.forItem(Command::parse);
  }
}
