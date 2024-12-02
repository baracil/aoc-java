package fpc.aoc.year2019.day21;

import fpc.aoc.api.Solver;
import lombok.NonNull;

import java.util.List;
import java.util.function.Function;

public class Day21Part1Solver extends Day21Solver {

  public static Solver provider() {
    return new Day21Part1Solver();
  }


  @Override
  int solve(Function<List<String>, Day21Solver.Result> executor) {
    final Result result = executor.apply(getLogicalProgram());
    return result.damage();
  }

  @Override
  int sensorRange() {
    return 4;
  }

  @Override
  String launchCommand() {
    return "WALK";
  }

  @NonNull
  public List<String> getLogicalProgram() {
    return List.of(
        "NOT C T",
        "AND D T",
        "NOT A J",
        "OR T J"
    );
  }

}
