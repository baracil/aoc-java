package fpc.aoc.year2020.day8;

import fpc.aoc.year2020.day8.structures.ExecutionContext;
import fpc.aoc.year2020.day8.structures.StopCondition;

import java.util.HashSet;
import java.util.Set;

public class Part1StopCondition implements StopCondition {

  private final Set<Integer> positionExecuted = new HashSet<>();

  @Override
  public boolean shouldStopExecution(ExecutionContext executionContext) {
    if (positionExecuted.contains(executionContext.pointer())) {
      return true;
    }
    positionExecuted.add(executionContext.pointer());
    return false;
  }
}
