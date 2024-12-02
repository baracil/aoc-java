package fpc.aoc.year2019.day4;

import fpc.aoc.api.Solver;

public class Day4Part2Solver extends BaseDay4Solver {

    public static Solver provider() {
        return new Day4Part2Solver();
    }

    @Override
    protected int solve(Code first, Code last) {
        int count = 0;
        first.normalize();
        while (first.compareTo(last) < 0) {
            if (first.hasTwoIsolateIdenticalConsecutiveDigits()) {
                count++;
            }
            first.moveToNextCodeWithIncreasingDigit();
        }
        return count;
    }
}
