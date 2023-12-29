package fpc.aoc.year2020.day8.structures;

import fpc.aoc.year2020.day8.structures.instruction.Acc;
import fpc.aoc.year2020.day8.structures.instruction.Jmp;
import fpc.aoc.year2020.day8.structures.instruction.Nop;
import lombok.NonNull;

import java.util.function.Function;

public interface InstructionVisitor<T> {

    @NonNull T visit(@NonNull Acc acc);
    @NonNull T visit(@NonNull Nop nop);
    @NonNull T visit(@NonNull Jmp jmp);

    default @NonNull Function<Instruction, T> asFunction() {
        return instruction -> instruction.accept(this);
    }
}
