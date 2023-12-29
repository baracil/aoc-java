package fpc.aoc.year2023.day06;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.List;

public abstract class Day6Solver extends SmartSolver<List<String>> {

    @Override
    protected @NonNull Converter<List<String>> getConverter() {
        return Converter.IDENTITY;
    }

}
