package fpc.aoc.year2021.day9;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

public abstract class Day9Solver extends SmartSolver<Map> {

    @Override
    protected @NonNull Converter<Map> getConverter() {
        return Map::parse;
    }
}
