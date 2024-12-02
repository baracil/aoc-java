package fpc.aoc.year2020.day8.structures;

import fpc.aoc.common.AOCException;
import fpc.aoc.year2020.day8.structures.instruction.Acc;
import fpc.aoc.year2020.day8.structures.instruction.Jmp;
import fpc.aoc.year2020.day8.structures.instruction.Nop;
import lombok.NonNull;

public sealed interface Instruction permits Acc, Jmp, Nop {

  ExecutionContext execute(ExecutionContext context);

  Instruction mutate();

  static Instruction parse(String line) {
    try {
      final String[] token = line.split(" ", 2);
      final Operation operation = Operation.find(token[0]);
      return operation.createInstruction(token[1]);
    } catch (Exception e) {
      throw new AOCException("Cannot parse instruction from line '" + line + "'", e);
    }
  }

  @NonNull
  Operation getOperation();
}

