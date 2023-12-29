package fpc.aoc.year2020.day8.structures;

import fpc.aoc.common.AOCException;
import fpc.aoc.common.TryResult;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class Processor {

  public static @NonNull Processor with(@NonNull StopCondition stopCondition) {
    return new Processor(stopCondition);
  }

  private final @NonNull StopCondition stopCondition;

  public TryResult<AOCException, ExecutionContext> launch(@NonNull Program program) {
    final Set<Integer> positionExecuted = new HashSet<>();
    var context = ExecutionContext.createInitial();
    while (true) {
      if (stopCondition.shouldStopExecution(context)) {
        return TryResult.success(context);
      }
      if (positionExecuted.contains(context.pointer())) {
        return TryResult.failure(new AOCException("Cyclic program : " + context.pointer()));
      }
      positionExecuted.add(context.pointer());

      final Instruction current = program.getInstructionAt(context.pointer());
      context = current.execute(context);
    }
  }

}
