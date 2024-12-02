package fpc.aoc.computer.primitive._private;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

public class VariableSizeMemory extends BaseMemory {

    private static final int CHUNK_SIZE = 1024;

    @NonNull
    private final Map<Integer,long[]> values = new HashMap<>();

    public VariableSizeMemory(long[] values) {
        int i = 0;
        while (values.length - i > 0) {
            final int toCopy = Math.min(CHUNK_SIZE, values.length - i);

            final long[] data = new long[CHUNK_SIZE];

            System.arraycopy(values,i,data,0,toCopy);

            this.values.put(i/CHUNK_SIZE,data);

            i+=CHUNK_SIZE;
        }
    }

    @Override
    protected LongStream streamOfValues() {
        return values.entrySet()
                     .stream()
                     .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .flatMapToLong(e -> Arrays.stream(e.getValue()));
    }

    @Override
    public void setValue(int address, long value) {
        final int chunkIdx = address/CHUNK_SIZE;
        final int addressInChunk = address%CHUNK_SIZE;
        final long[] chunk = values.computeIfAbsent(chunkIdx,i -> new long[CHUNK_SIZE]);
        chunk[addressInChunk] = value;
    }

    @Override
    public long getValueAt(int address) {
        final int chunkIdx = address/CHUNK_SIZE;
        final int addressInChunk = address%CHUNK_SIZE;
        final long[] chunk = values.get(chunkIdx);
        return chunk == null?0:chunk[addressInChunk];
    }
}
