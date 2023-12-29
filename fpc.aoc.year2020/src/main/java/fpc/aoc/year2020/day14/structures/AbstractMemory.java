package fpc.aoc.year2020.day14.structures;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMemory implements Memory {

    private final Map<Long,Long> values = new HashMap<>();

    private Mask mask;

    protected void putValueInMemory(long addr, long value) {
        values.put(addr,value);
    }

    @Override
    public void setActiveMask(@NonNull Mask mask) {
        this.mask = mask;
    }

    protected @NonNull Mask getActiveMask() {
        assert mask!=null;
        return mask;
    }

    @Override
    public long sumOfAllValues() {
        return values.values().stream().mapToLong(l -> l).sum();
    }
}
