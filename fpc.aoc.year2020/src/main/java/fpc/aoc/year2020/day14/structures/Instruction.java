package fpc.aoc.year2020.day14.structures;

import fpc.aoc.common.AOCException;

public interface Instruction {

  static Instruction parse(String line) {
    if (line.startsWith("mask")) {
      return Mask.parse(line);
    } else if (line.startsWith("mem")) {
      return Setter.parse(line);
    }
    throw new AOCException("Could not parse line '" + line + "'");
  }

  void applyToMemory(Memory memory);
}
