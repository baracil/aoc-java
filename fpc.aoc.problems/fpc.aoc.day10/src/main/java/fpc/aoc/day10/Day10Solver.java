package fpc.aoc.day10;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day10Solver extends SmartSolver<Map,Integer> {

    @Override
    protected @NonNull Converter<Map> getConverter() {
        return s -> s.collect(Map.COLLECTOR);
    }
}
