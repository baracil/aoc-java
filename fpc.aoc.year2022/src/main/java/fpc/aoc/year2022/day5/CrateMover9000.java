package fpc.aoc.year2022.day5;

public class CrateMover9000 implements CrateMover {

  public void performProcedureStep(Stacks stacks, ProcedureStep procedureStep) {
    for (int i = 0; i < procedureStep.repetition(); i++) {
      final var c = stacks.pick(procedureStep.originStack());
      stacks.put(procedureStep.targetStack(), c);
    }
  }
}
