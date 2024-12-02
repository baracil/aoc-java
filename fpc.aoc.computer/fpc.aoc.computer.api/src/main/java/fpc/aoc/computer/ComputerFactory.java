package fpc.aoc.computer;

import lombok.NonNull;

public interface ComputerFactory {


    boolean verifyAllProperties(BitSize minimalBitSize,MemoryType memoryType);

    @NonNull
    Computer create();

}
