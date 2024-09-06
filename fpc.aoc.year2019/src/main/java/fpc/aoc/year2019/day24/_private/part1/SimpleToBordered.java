package fpc.aoc.year2019.day24._private.part1;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.IntUnaryOperator;

/**
 * @author perococco
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleToBordered implements IntUnaryOperator {

    private static final SimpleToBordered INSTANCE = new SimpleToBordered();

    public static SimpleToBordered instance() {
        return INSTANCE;
    }

    /*
     *  0  .......
     *  7  .-A-A-.   8 10 12  16 18  22 24 26  30 32  36 38 40
     * 14  .A-A-A.    9 11   15 17 19  23 25  29 31 33  37 39
     * 21  .-A-A-.   2^12 = 4096 : even
     * 28  .A-A-A.   2^13 = 8192 : odd
     * 35  .-A-A-.
     */
    //0   1   2   3   4  |  5   6   7   8   9  |  10  11  12  13  14  |  15  16  17  18  19  |  20  21  22  23  24
    //8   9  10  11  12  | 15  16  17  18  19  |  22  23  24  25  26  |  29  30  31  32  33  |  36  37  38  39  40

    @Override
    public int applyAsInt(int position) {
        final int line = position/5;
        return position + 8 + 2*line;
    }
}
