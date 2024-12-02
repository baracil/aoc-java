package fpc.aoc.year2019.day18._private;

import fpc.aoc.common.AOCException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class KeyRepository {

    private final Map<String,Key> cache = new HashMap<>();

    private int bit = 0;

    @NonNull
    @Synchronized
    public Key get(String id) {
        return cache.computeIfAbsent(id, this::create);
    }

    private Key create(String id) {
        if (bit>=Long.SIZE) {
            throw new AOCException("Too many keys");
        }
        final long mask = 1L<<bit;
        bit++;
        return new Key(id,mask);
    }

}
