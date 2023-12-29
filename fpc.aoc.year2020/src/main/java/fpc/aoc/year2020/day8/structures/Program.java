package fpc.aoc.year2020.day8.structures;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Program {

    @Getter
    private final @NonNull List<Instruction> code;

    public @NonNull Instruction getInstructionAt(int pointer) {
        return code.get(pointer);
    }

    public int codeSize() {
        return code.size();
    }
}
