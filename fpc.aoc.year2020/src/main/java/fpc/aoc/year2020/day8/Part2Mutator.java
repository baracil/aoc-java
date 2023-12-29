package fpc.aoc.year2020.day8;

import fpc.aoc.year2020.day8.structures.Instruction;
import fpc.aoc.year2020.day8.structures.InstructionVisitor;
import fpc.aoc.year2020.day8.structures.instruction.Acc;
import fpc.aoc.year2020.day8.structures.instruction.Jmp;
import fpc.aoc.year2020.day8.structures.instruction.Nop;
import lombok.NonNull;

public class Part2Mutator implements InstructionVisitor<Instruction> {

    @Override
    public @NonNull Instruction visit(@NonNull Acc acc) {
        return acc;
    }

    @Override
    public @NonNull Instruction visit(@NonNull Nop nop) {
        return new Jmp(nop.argument());
    }

    @Override
    public @NonNull Instruction visit(@NonNull Jmp jmp) {
        return new Nop(jmp.offset());
    }
}
