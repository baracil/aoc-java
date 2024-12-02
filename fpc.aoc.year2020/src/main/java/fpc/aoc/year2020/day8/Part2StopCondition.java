package fpc.aoc.year2020.day8;

import fpc.aoc.year2020.day8.structures.ExecutionContext;
import fpc.aoc.year2020.day8.structures.Program;
import fpc.aoc.year2020.day8.structures.StopCondition;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Part2StopCondition implements StopCondition {

  public static Part2StopCondition createFor(Program program) {
    return new Part2StopCondition(program.codeSize());
  }

  private final int codeSize;

  @Override
  public boolean shouldStopExecution(ExecutionContext executionContext) {
    return executionContext.pointer() >= codeSize;
  }
}
