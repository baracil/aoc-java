package fpc.aoc.computer;

import lombok.NonNull;

public interface ComputerFactory {


    boolean verifyAllProperties(@NonNull BitSize minimalBitSize,@NonNull MemoryType memoryType);

    @NonNull
    Computer create();

}
