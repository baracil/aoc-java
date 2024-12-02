package fpc.aoc.computer.primitive;

import fpc.aoc.computer.BitSize;
import fpc.aoc.computer.Computer;
import fpc.aoc.computer.ComputerFactory;
import fpc.aoc.computer.MemoryType;
import fpc.aoc.computer.primitive._private.PrimitiveComputer;
import fpc.aoc.computer.primitive._private.VariableSizeMemory;

public class VariableSizeLongValueComputerFactory implements ComputerFactory {

    @Override
    public boolean verifyAllProperties(BitSize minimalBitSize,MemoryType memoryType) {
        return (minimalBitSize == BitSize.BIT_32 || minimalBitSize == BitSize.BIT_64) && memoryType == MemoryType.VARIABLE;
    }

    @Override
    public Computer create() {
        return new PrimitiveComputer(VariableSizeMemory::new);
    }
}
