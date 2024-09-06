package fpc.aoc.computer.primitive;

import fpc.aoc.computer.BitSize;
import fpc.aoc.computer.Computer;
import fpc.aoc.computer.ComputerFactory;
import fpc.aoc.computer.MemoryType;
import fpc.aoc.computer.primitive._private.FixedSizeMemory;
import fpc.aoc.computer.primitive._private.PrimitiveComputer;
import lombok.NonNull;

public class FixSizeLongValueComputerFactory implements ComputerFactory {

    @Override
    public boolean verifyAllProperties(@NonNull BitSize minimalBitSize,@NonNull MemoryType memoryType) {
        return (minimalBitSize == BitSize.BIT_32 || minimalBitSize == BitSize.BIT_64) && memoryType == MemoryType.FIXED;
    }

    @Override
    public @NonNull Computer create() {
        return new PrimitiveComputer(FixedSizeMemory::new);
    }
}
