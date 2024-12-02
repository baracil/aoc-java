package fpc.aoc.year2020.day6;

import fpc.aoc.api.Solver;
import fpc.aoc.year2020.day6.structures.Group;

import java.util.List;

public class Day6Part1Solver extends Day6Solver {

  public static Solver provider() {
    return new Day6Part1Solver();
  }

  @Override
  public Integer doSolve(List<Group> input) {
    return input.stream()
        .mapToInt(Group::getNumberOfDistinctQuestions)
        .sum();
  }
}
