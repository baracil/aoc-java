package fpc.aoc.year2019.day16;

import fpc.aoc.api.Solver;

public class Day16Part2Solver extends Day16Solver {

    public static Solver provider() {
        return new Day16Part2Solver();
    }


    @Override
    protected Object doSolve(Signal signal) {
        final int offset = Integer.parseInt(signal.getFirstSeventhDigits());
        final Signal signal1 = signal.duplicate(10000).truncate(offset).applyFFT(100);

        return signal1.getFirstEightDigits();
    }
}
