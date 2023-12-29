package fpc.aoc.year2020.day6;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import fpc.aoc.year2020.day6.structures.Group;
import fpc.aoc.year2020.day6.structures.GroupListBuilder;
import lombok.NonNull;

import java.util.List;

public abstract class Day6Solver extends SmartSolver<List<Group>> {

  @Override
  protected @NonNull Converter<List<Group>> getConverter() {
    return GroupListBuilder::build;
  }
}
