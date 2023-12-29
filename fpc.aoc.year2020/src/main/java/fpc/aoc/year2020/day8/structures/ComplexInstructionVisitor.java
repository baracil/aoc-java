package fpc.aoc.year2020.day8.structures;

import fpc.aoc.year2020.day8.structures.instruction.Acc;
import fpc.aoc.year2020.day8.structures.instruction.Jmp;
import fpc.aoc.year2020.day8.structures.instruction.Nop;
import lombok.NonNull;

public interface ComplexInstructionVisitor<P, T> {

  @NonNull
  T visit(@NonNull Acc acc, @NonNull P parameter);

  @NonNull
  T visit(@NonNull Nop nop, @NonNull P parameter);

  @NonNull
  T visit(@NonNull Jmp jmp, @NonNull P parameter);
}
