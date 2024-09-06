package fpc.aoc.year2019.day24._private.part1;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Map;

/**
 *  *  *   f(i) = 1 + !1.2.!i = 1 + 2.!i
 * @author perococco
 **/
@RequiredArgsConstructor
public class SubLayout {

    private final int mask;
    private final int borderMask;

    @NonNull
    private final Map<Integer,Masks> cacheMap;

    public int apply(int layout) {
        final int border = layout&borderMask;
        final int subLayout = layout&mask;
        final Masks cache = cacheMap.get(border);

        return cache.one() | ( cache.two() & ~subLayout );
    }
}
