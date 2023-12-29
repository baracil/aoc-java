package fpc.aoc.year2020.day8.structures.instruction;

import fpc.aoc.year2020.day8.structures.ExecutionContext;
import fpc.aoc.year2020.day8.structures.Instruction;
import fpc.aoc.year2020.day8.structures.Operation;
import lombok.NonNull;
import lombok.Value;

@Value
public class Nop implements Instruction {

  public static Nop parse(@NonNull String argument) {
    return new Nop(Integer.parseInt(argument));
  }

  int argument;

  @Override
  public Instruction mutate() {
    return new Jmp(argument);
  }

  @Override
  public ExecutionContext execute(ExecutionContext context) {
    return context.moveBy(1);
  }

  @Override
  public @NonNull Operation getOperation() {
    return Operation.NOP;
  }
}
