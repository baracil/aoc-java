package fpc.aoc.year2020.day8.structures;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Program {

  private final List<Instruction> code;

  public Instruction getInstructionAt(int pointer) {
    return code.get(pointer);
  }

  public int codeSize() {
    return code.size();
  }
}
