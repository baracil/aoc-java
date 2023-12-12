package fpc.aoc.day12;

import fpc.aoc.input.Converter;
import fpc.aoc.input.SmartSolver;
import lombok.NonNull;

import java.util.stream.Stream;

public abstract class Day12Solver extends SmartSolver<Stream<Row>,Long> {

    @Override
    protected @NonNull Converter<Stream<Row>> getConverter() {
        return s -> s.map(Row::parse);
    }
}
