package fpc.aoc.year2020.day14.structures;

import fpc.aoc.common.AOCException;
import lombok.NonNull;

public interface Instruction {

  static @NonNull Instruction parse(@NonNull String line) {
    if (line.startsWith("mask")) {
      return Mask.parse(line);
    } else if (line.startsWith("mem")) {
      return Setter.parse(line);
    }
    throw new AOCException("Could not parse line '" + line + "'");
  }

  void applyToMemory(@NonNull Memory memory);
}
