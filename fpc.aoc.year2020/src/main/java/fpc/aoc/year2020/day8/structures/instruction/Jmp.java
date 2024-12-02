package fpc.aoc.year2020.day8.structures.instruction;

import fpc.aoc.year2020.day8.structures.ExecutionContext;
import fpc.aoc.year2020.day8.structures.Instruction;
import fpc.aoc.year2020.day8.structures.Operation;
import lombok.Value;

@Value
public class Jmp implements Instruction {

  public static Jmp parse(String argument) {
    return new Jmp(Integer.parseInt(argument));
  }

  int offset;

  @Override
  public Instruction mutate() {
    return new Nop(offset);
  }

  @Override
  public ExecutionContext execute(ExecutionContext context) {
    return context.moveBy(offset);
  }

  @Override
  public Operation getOperation() {
    return Operation.JMP;
  }
}
