package fpc.aoc.year2020.day8.structures;

import fpc.aoc.common.AOCException;
import fpc.aoc.year2020.day8.structures.instruction.Acc;
import fpc.aoc.year2020.day8.structures.instruction.Jmp;
import fpc.aoc.year2020.day8.structures.instruction.Nop;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Operation {
  ACC(Acc::parse),
  NOP(Nop::parse),
  JMP(Jmp::parse),
  ;

  private final Function<? super String, ? extends Instruction> factory;

  public static Operation find(String name) {
    final var operation = Holder.OPERATION_BY_NAME.get(name.toLowerCase());
    if (operation == null) {
      throw new AOCException("No operation found with name '" + name + "'");
    }
    return operation;
  }

  public Instruction createInstruction(String argument) {
    return factory.apply(argument);
  }

  private static class Holder {

    private static final Map<String, Operation> OPERATION_BY_NAME;

    static {
      OPERATION_BY_NAME = Arrays.stream(values())
          .collect(Collectors.toMap(op -> op.name().toLowerCase(), op -> op));
    }

  }

}
