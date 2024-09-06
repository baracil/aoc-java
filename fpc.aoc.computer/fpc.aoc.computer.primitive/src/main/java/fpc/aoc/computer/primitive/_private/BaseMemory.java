package fpc.aoc.computer.primitive._private;

import fpc.aoc.computer.Alterations;
import fpc.aoc.computer.MemoryAccessors;
import lombok.NonNull;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public abstract class BaseMemory implements Memory {

    private final MemoryAccessors accessors;

    public BaseMemory() {
        this.accessors = new Accessors();
    }

    @Override
    public @NonNull MemoryAccessors hasMemoryAccessors() {
        return accessors;
    }

    @Override
    public void alter(@NonNull Alterations alterations) {
        alterations.handleAlterations(this::alter);
    }

    private void alter(int address, @NonNull String value) {
        setValue(address, Long.parseLong(value));
    }

    protected abstract LongStream streamOfValues();

    private class Accessors implements MemoryAccessors {

        @Override
        public String getValueAt(int address) {
            return String.valueOf(BaseMemory.this.getValueAt(address));
        }

        @Override
        public String dumpMemory() {
            return streamOfValues()
                         .mapToObj(String::valueOf)
                         .collect(Collectors.joining(","));
        }
    }

}
