package fpc.aoc.year2022.day3;

import fpc.aoc.api.Solver;
import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;

import java.util.ArrayList;
import java.util.List;

public class Day3Part2Solver extends SmartSolver<List<Group>> {

  public static Solver provider() {
    return new Day3Part2Solver();
  }

  @Override
  public Integer doSolve(List<Group> input) {
    return input.stream().mapToInt(g -> g.getCommonItem() + 1).sum();
  }

  @Override
  protected Converter<List<Group>> getConverter() {
    return Converter.forItem(Compartment::parse)
        .andThen(this::toGroups);
  }


  private List<Group> toGroups(List<Compartment> lines) {
    final List<Group> groups = new ArrayList<>();
    for (int i = 0; i < lines.size(); i += 3) {
      groups.add(new Group(lines.subList(i, i + 3)));
    }
    return groups;
  }

}
