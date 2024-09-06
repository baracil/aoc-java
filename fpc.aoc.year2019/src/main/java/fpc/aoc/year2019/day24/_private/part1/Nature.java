package fpc.aoc.year2019.day24._private.part1;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *
 *   -A-A-
 *   A-A-A
 *   -A-A- 2^12 = 4096 : even
 *   A-A-A 2^13 = 8192 : odd
 *   -A-A-
 *                   12| 0  1
 *        0  1         |-----
 *  1 ->  1  1       00| 0  0
 *  2 ->  1  0       01| 1  0
 *                   11| x  x
 *                   10| 1  1
 *
 *   f(i) = 1 + !1.2.!i = 1 + 2.!i
 *
 * @author perococco
 **/
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Nature {

    @NonNull
    public static Nature create() {
        return new Nature(MaskBuilder.buildOdd(), MaskBuilder.buildEven());
    }

    @NonNull
    private final SubLayout odd;

    @NonNull
    private final SubLayout even;

    public int evolve(int layout) {
        return odd.apply(layout) | even.apply(layout);
    }

}
