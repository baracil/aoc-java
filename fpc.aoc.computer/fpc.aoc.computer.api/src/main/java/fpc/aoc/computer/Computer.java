package fpc.aoc.computer;

import fpc.aoc.computer._private.ComputerFromServiceLoader;
import lombok.NonNull;

public interface Computer {

    @NonNull
    static Computer create(@NonNull BitSize minimalBitSize,@NonNull MemoryType memoryType) {
        return new ComputerFromServiceLoader(minimalBitSize,memoryType);
    }

    @NonNull
    static Computer create() {
        return new ComputerFromServiceLoader(BitSize.BIT_64,MemoryType.VARIABLE);
    }

    @NonNull
    static Program compileProgram(@NonNull String code) {
        return create().compile(code);
    }

    @NonNull
    Program compile(@NonNull String code);

}
