package fpc.aoc.year2019.day4;

import fpc.aoc.api.Solver;
import lombok.NonNull;

public class Day4Part1Solver extends BaseDay4Solver {

    public static Solver provider() {
        return new Day4Part1Solver();
    }

    @Override
    protected int solve(@NonNull Code first, @NonNull Code last) {
        int count = 0;
        first.normalize();
        while (first.compareTo(last) < 0) {
            if (first.hasTwoIdenticalConsecutiveDigits()) {
                count++;
            }
            first.moveToNextCodeWithIncreasingDigit();
        }
        return count;
    }
}
