package fpc.aoc.year2020.day10;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day10Solver extends SmartSolver<int[]> {

    @Override
    protected @NonNull Converter<int[]> getConverter() {
        return Converter.TO_ARRAY_OF_INT;
    }
}
