package fpc.aoc.year2020.day8.structures.instruction;

import fpc.aoc.year2020.day8.structures.ExecutionContext;
import fpc.aoc.year2020.day8.structures.Instruction;
import fpc.aoc.year2020.day8.structures.Operation;
import lombok.Value;

@Value
public class Acc implements Instruction {

  public static Acc parse(String argument) {
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
  public Operation getOperation() {
    return Operation.ACC;
  }
}
