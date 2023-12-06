package fpc.aoc.day6;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.List;

public abstract class Day6Solver extends SmartSolver<List<String>,Long> {

    @Override
    protected @NonNull Converter<List<String>> getConverter() {
        return Converter.ALL_LINES;
    }

}
