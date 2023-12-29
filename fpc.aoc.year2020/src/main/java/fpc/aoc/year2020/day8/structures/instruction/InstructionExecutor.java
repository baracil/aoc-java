package fpc.aoc.year2020.day8.structures.instruction;

import fpc.aoc.year2020.day8.structures.ComplexInstructionVisitor;
import fpc.aoc.year2020.day8.structures.ExecutionContext;
import lombok.NonNull;

public class InstructionExecutor implements ComplexInstructionVisitor<ExecutionContext, ExecutionContext> {

  @Override
  public @NonNull ExecutionContext visit(@NonNull Acc acc, @NonNull ExecutionContext parameter) {
    return parameter.addToAccumulator(acc.increment()).moveBy(1);
  }

  @Override
  public @NonNull ExecutionContext visit(@NonNull Nop nop, @NonNull ExecutionContext parameter) {
    return parameter.moveBy(1);
  }

  @Override
  public @NonNull ExecutionContext visit(@NonNull Jmp jmp, @NonNull ExecutionContext parameter) {
    return parameter.moveBy(jmp.offset());
  }
}
