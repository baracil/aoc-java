package fpc.aoc.computer.primitive._private;

import fpc.aoc.computer.Alterations;
import fpc.aoc.computer.MemoryAccessors;
import lombok.NonNull;

public interface Memory {

    void setValue(int address, long value);

    void alter(@NonNull Alterations alterations);

    long getValueAt(int address);

    @NonNull
    MemoryAccessors hasMemoryAccessors();

}
