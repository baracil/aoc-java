package fpc.aoc.year2020.day8.structures.instruction;

import fpc.aoc.year2020.day8.structures.ExecutionContext;
import fpc.aoc.year2020.day8.structures.Instruction;
import fpc.aoc.year2020.day8.structures.Operation;
import lombok.NonNull;
import lombok.Value;

@Value
public class Acc implements Instruction {

  public static Acc parse(@NonNull String argument) {
    return new Acc(Integer.parseInt(argument));
  }

  int increment;

    @Override
    public Instruction mutate() {
        return this;
    }

    @Override
    public ExecutionContext execute(ExecutionContext context) {
        return context.addToAccumulator(increment).moveBy(1);
    }

  @Override
  public @NonNull Operation getOperation() {
    return Operation.ACC;
  }
}
