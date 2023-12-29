package fpc.aoc.year2022.day5;

import lombok.NonNull;

import java.util.Deque;
import java.util.LinkedList;

public class CrateMover9001 implements CrateMover {

  private final Deque<String> buffer = new LinkedList<>();

  public void performProcedureStep(@NonNull Stacks stacks, @NonNull ProcedureStep procedureStep) {
    for (int i = 0; i < procedureStep.repetition(); i++) {
      final var c = stacks.pick(procedureStep.originStack());
      buffer.addLast(c);
    }

    while (!buffer.isEmpty()) {
      stacks.put(procedureStep.targetStack(), buffer.removeLast());
    }


  }
}
