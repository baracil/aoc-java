package fpc.aoc.year2021.day11;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day11Solver extends SmartSolver<Map> {

    @Override
    protected @NonNull Converter<Map> getConverter() {
        return ArrayMap::parse;
    }
}
