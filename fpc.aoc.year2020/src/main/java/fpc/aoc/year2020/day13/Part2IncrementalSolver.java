package fpc.aoc.year2020.day13;

import fpc.aoc.common.Tools;
import lombok.NonNull;

import java.math.BigInteger;
import java.util.List;

public class Part2IncrementalSolver implements Part2Solver {

    @Override
    public @NonNull BigInteger doSolve(@NonNull List<Bus> buses) {
        var factor = BigInteger.ONE;
        var timeStamp = BigInteger.ZERO;
        for (int i = 0; i < buses.size(); i++) {
            var bus = buses.get(i);
            if (bus.isOutOfService()) {
                continue;
            }
            var busId = bus.id().intValue();
            int targetRemain = Tools.mod(busId-i, busId);
            while(timeStamp.mod(bus.id()).intValue() != targetRemain) {
                timeStamp = timeStamp.add(factor);
            }
            factor = factor.multiply(bus.id());
        }
        return timeStamp;

    }
}
