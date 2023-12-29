package fpc.aoc.year2020.day13;

import lombok.NonNull;
import lombok.Value;

import java.math.BigInteger;

@Value
public class NextStop {

    @NonNull Bus bus;

    @NonNull BigInteger waitingTime;

    public BigInteger busId() {
        return bus.id();
    }
}
