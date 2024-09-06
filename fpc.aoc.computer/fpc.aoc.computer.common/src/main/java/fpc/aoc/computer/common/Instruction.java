package fpc.aoc.computer.common;

import lombok.NonNull;
import lombok.Value;

@Value
public class Instruction {

  String opCode;
  Modes modes;

  public Instruction(@NonNull String instructionCode) {
    final int length = instructionCode.length();
    if (length <= 2) {
      this.opCode = instructionCode;
      this.modes = new Modes("");
    } else {
      this.opCode = instructionCode.substring(length - 2);
      this.modes = new Modes(instructionCode.substring(0, length - 2));
    }
  }

  public boolean stopInstruction() {
    return opCode.equals("99");
  }

}
