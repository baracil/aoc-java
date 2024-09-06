package fpc.aoc.computer.primitive._private;

import lombok.NonNull;

import java.util.Arrays;
import java.util.stream.LongStream;

public class FixedSizeMemory extends BaseMemory {

    @NonNull
    private final long[] values;

    public FixedSizeMemory(@NonNull long[] values) {
        this.values = values;
    }

    @Override
    protected LongStream streamOfValues() {
        return Arrays.stream(values);
    }

    @Override
    public void setValue(int address, long value) {
        values[address] = value;
    }

    @Override
    public long getValueAt(int address) {
        return values[address];
    }
}
