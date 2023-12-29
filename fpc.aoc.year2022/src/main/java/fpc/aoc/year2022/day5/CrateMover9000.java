package fpc.aoc.year2022.day5;

import lombok.NonNull;

public class CrateMover9000 implements CrateMover {

  public void performProcedureStep(@NonNull Stacks stacks, @NonNull ProcedureStep procedureStep) {
    for (int i = 0; i < procedureStep.repetition(); i++) {
      final var c = stacks.pick(procedureStep.originStack());
      stacks.put(procedureStep.targetStack(), c);
    }
  }
}
