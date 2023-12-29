package fpc.aoc.year2020.day13;

import lombok.NonNull;

import java.math.BigInteger;
import java.util.List;

public interface Part2Solver {

    @NonNull BigInteger doSolve(@NonNull List<Bus> buses);
}
